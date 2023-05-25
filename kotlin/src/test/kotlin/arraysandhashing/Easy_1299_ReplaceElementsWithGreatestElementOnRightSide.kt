package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max

class Easy_1299_ReplaceElementsWithGreatestElementOnRightSide {

    @Test
    fun testCase() {
        assertThat(replaceElements(intArrayOf(17, 18, 5, 4, 6, 1)))
            .isEqualTo(intArrayOf(18, 6, 6, 6, 1, -1))
        assertThat(replaceElements(intArrayOf(400)))
            .isEqualTo(intArrayOf(-1));
    }

    private fun replaceElements(arr: IntArray): IntArray {
        var rightMax = -1

        for (i in arr.size - 1 downTo 0) {
            val newMax = max(rightMax, arr[i])
            arr[i] = rightMax
            rightMax = newMax
        }

        return arr

    }

}