package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 605. Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)
 */
class Easy_605_CanPlaceFlowersTest {
    @Test
    fun testCase() {
        assertThat(canPlaceFlowers2(arrayOf(0), 0)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(0), 1)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(1), 0)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(1), 1)).isFalse()
        assertThat(canPlaceFlowers2(arrayOf(0, 0), 1)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(0, 0), 2)).isFalse()
        assertThat(canPlaceFlowers2(arrayOf(1, 0, 0, 0, 1), 1)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(1, 0, 0, 0, 1), 2)).isFalse()
        assertThat(canPlaceFlowers2(arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1), 3)).isTrue()
        assertThat(canPlaceFlowers2(arrayOf(0, 0, 1, 0, 0), 1)).isTrue()
    }

    /**
     * The trick here is to think that there are empty plots on both ends of the flower bed, ie. for a flowerbed of
     * [0], imagine that it's actually [0,0,0]. Then, check if the element is empty or has a flower. If empty, check the
     * adjacent elements if they're also empty.
     */
    private fun canPlaceFlowers2(flowerbed: Array<Int>, n: Int): Boolean {
        var m = n

        flowerbed.forEachIndexed { index, value ->
            val left = if (index == 0) {
                0
            } else {
                flowerbed[index - 1]
            }

            val right = if (index == flowerbed.size - 1) {
                0
            } else {
                flowerbed[index + 1]
            }

            if (value == 0 && left == 0 && right == 0) {
                flowerbed[index] = 1
                m--
            }
        }

        return m <= 0
    }

}