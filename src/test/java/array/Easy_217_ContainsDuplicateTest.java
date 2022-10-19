package array;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">Question 217</a>
 * <p>Given an integer array nums, return true if any value appears at least twice in the array, and return false if
 * every element is distinct.</p>
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * </pre>
 */
class Easy_217_ContainsDuplicateTest {

    @Test
    void testCases() {
        assertThat(Solution.containsDuplicate(new int[]{1, 2, 3, 1})).isTrue();
        assertThat(Solution.containsDuplicate(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(Solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})).isTrue();
    }

    /**
     * Use a Set to store the numbers and to check if there are duplicates
     */
    private static class Solution {
        private static boolean containsDuplicate(int[] nums) {
            var set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                } else {
                    set.add(num);
                }
            }
            return false;
        }
    }

}
