package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 169. Majority Element](https://leetcode.com/problems/majority-element/description)
 */
class Easy_169_MajorityElementTest {

    @Test
    fun testCase() {
        assertThat(majorityElement(intArrayOf(3, 2, 3))).isEqualTo(3)
        assertThat(majorityElement(intArrayOf(6, 5, 5))).isEqualTo(5)
        assertThat(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))).isEqualTo(2)
    }

    /**
     * Use hashmap way to solve the problem.
     */
    private fun majorityElement(nums: IntArray): Int {
        return nums
            .groupBy { it } // groups same numbers together, ie given [3,2,3], returns {3=[3,3], 2=[2]}
            .mapValues { it.value.size } // transforms the values using the size of the list, ie given {3=[3,3], 2=[2]}, transforms to {3=2, 2=1}
            .entries.maxBy { it.value }!!.key // from the entries, gets the pair with the highest value, and returns the key
    }

    /**
     * Uses the Boyer-Moore Algorithm. Only works if there is a guaranteed majority element. Uses O(1) space.
     */
    private fun majorityElement2(nums: IntArray): Int {
        var res = 0
        var count = 0

        for ((index, value) in nums.withIndex()) {
            if (index != 0) {
                if (res == value) {
                    count++
                } else {
                    if (count - 1 != -1) {
                        count--
                    } else {
                        res = value
                        count = 1
                    }
                }
            } else {
                res = value
                count++
            }
        }

        return res
    }

}