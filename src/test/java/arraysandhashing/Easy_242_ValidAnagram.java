package arraysandhashing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">Question 242</a>
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * </p>
 *
 * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
 * all the original letters exactly once.
 * </p>
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * </pre>
 */
class Easy_242_ValidAnagram {

    @Test
    void testCases() {
        assertThat(Solution.isAnagram("anagram", "nagaram")).isTrue();
        assertThat(Solution.isAnagram("rat", "car")).isFalse();
    }


    /**
     * <p>
     * This solution uses an array. The index of the array corresponds to the natural order of the alpha characters,
     * i.e. a = 0, b = 1, c = 2, etc.
     * </p>
     *
     * <p>
     * For the first word, we increment the values in the array. For the second word, we decrement. If the words
     * are anagrams, all the values in the array should be zero.
     * </p>
     */
    private static class Solution {
        private static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }

            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
