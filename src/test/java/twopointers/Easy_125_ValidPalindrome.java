package twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">Question 125</a>
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
 * and numbers.
 * </p>
 *
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * </p>
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * </pre>
 */
class Easy_125_ValidPalindrome {

    @Test
    void testCases() {
        assertThat(Solution.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
        assertThat(Solution.isPalindrome("race a car")).isFalse();
        assertThat(Solution.isPalindrome(" ")).isTrue();
        assertThat(Solution.isPalindrome("+....,")).isTrue();
    }

    /**
     * <p>
     * The solution uses two pointers, the left and right pointers. The idea is for the pointers to compare the
     * character on their current position.
     * </p>
     * <p>
     * The complexity here is that non-ASCII characters should be skipped. To do that, if a character is non-ASCII,
     * we move increment the left pointer, or decrement the right pointer. Once both left and right pointers are
     * ASCII, we can finally compare. Don't forget to compare ignoring the case.
     * </p>
     */
    private static class Solution {
        private static boolean isPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                if (!Character.isLetterOrDigit(s.charAt(l))) {
                    l++;
                    continue;
                }

                if (!Character.isLetterOrDigit(s.charAt(r))) {
                    r--;
                    continue;
                }

                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }
    }
}
