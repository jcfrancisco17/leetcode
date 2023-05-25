package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Stack

class Easy_682_BaseballGameTest {

    @Test
    fun testCases() {
        assertThat(calPoints(arrayOf("5", "2", "C", "D", "+"))).isEqualTo(30)
        assertThat(calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+"))).isEqualTo(27)
        assertThat(calPoints(arrayOf("1", "C"))).isZero()
    }

    private fun calPoints(operations: Array<String>): Int {
        val stack = Stack<Int>()

        operations.forEach { operation ->
            when (operation) {
                "+" -> {
                    stack.push(stack.peek() + stack[stack.size - 2])
                }

                "D" -> {
                    stack.push(stack.peek() * 2)
                }

                "C" -> {
                    stack.pop()
                }

                else -> {
                    stack.push(operation.toInt())
                }
            }
        }
        return stack.sum()
    }

}