package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 27. Remove Element](https://leetcode.com/problems/remove-element/)
 */
class Easy_27_RemoveElementTest {

    @Test
    fun testCase() {
        assertThat(removeElement(intArrayOf(3, 2, 2, 3), 3)).isEqualTo(2);
        assertThat(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2)).isEqualTo(5);
    }

    private fun removeElement(nums: IntArray, `val`: Int): Int {
        // initialize two pointers, reader and writer
        // reader will continuously loop, while writer will stop at index of target value
        // if the reader finds a non-matching target, they will swap values with the writer
        // when the reader reaches the last number, return the value of writer

        var writer = 0
        var reader = 0
        while (reader < nums.size) {
            if (nums[writer] != `val`) {
                writer++
            } else if (nums[writer] == `val` && nums[reader] != `val`) {
                nums[writer] = nums[reader]
                nums[reader] = `val`
                writer++
            }
            reader++
        }
        return writer
    }
}