package arraysandhashing

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

/**
 * [Question 1. Two Sum](https://leetcode.com/problems/two-sum/)
 */
class Easy_1_TwoSumTest {

    @Test
    fun testCase() {
        assertThat(twoSum(arrayOf(2, 7, 11, 15), 9)).isEqualTo(arrayOf(0, 1))
        assertThat(twoSum(arrayOf(3, 2, 4), 6)).isEqualTo(arrayOf(1, 2))
        assertThat(twoSum(arrayOf(3, 3), 6)).isEqualTo(arrayOf(0, 1))
    }

    private fun twoSum(nums: Array<Int>, target: Int): Array<Int?> {
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, value ->
            val diff = target - value
            if (map.contains(diff)) {
                return arrayOf(map[diff], index)
            } else {
                map[value] = index
            }
        }
        return arrayOf()
    }

}