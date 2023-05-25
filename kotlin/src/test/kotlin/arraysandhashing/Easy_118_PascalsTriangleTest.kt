package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)
 */
class Easy_118_PascalsTriangleTest {

    @Test
    fun testCase() {
        assertThat(generate(5))
            .isEqualTo(listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1)));

        assertThat(generate(1))
            .isEqualTo(listOf(listOf(1)))

        assertThat(generate(2))
            .isEqualTo(listOf(listOf(1), listOf(1, 1)))

        assertThat(generate(3))
            .isEqualTo(listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1)))

    }

    private fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 1) {
            return listOf(listOf(1))
        }

        if (numRows == 2) {
            return listOf(listOf(1), listOf(1, 1))
        }

        val triangle = mutableListOf(listOf(1), listOf(1, 1))
        for (i in 1 until numRows - 1) {
            val currentArray = triangle[i]
            val newArray = mutableListOf(1)
            for (j in 0 until currentArray.size - 1) {
                newArray.add(currentArray[j] + currentArray[j + 1])
            }
            newArray.add(1)
            triangle.add(newArray)
        }

        return triangle
    }
}