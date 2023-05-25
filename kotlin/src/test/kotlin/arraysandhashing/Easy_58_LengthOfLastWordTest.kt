package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 58. Length of Last Word](https://leetcode.com/problems/longest-common-prefix/)
 */
class Easy_58_LengthOfLastWordTest {

    @Test
    fun testCase() {
        assertThat(lengthOfLastWord2("Hello World")).isEqualTo(5);
        assertThat(lengthOfLastWord2("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(lengthOfLastWord2("luffy is still joyboy")).isEqualTo(6);
        assertThat(lengthOfLastWord2("a")).isEqualTo(1);
        assertThat(lengthOfLastWord2("a ")).isEqualTo(1);
        assertThat(lengthOfLastWord2(" a")).isEqualTo(1);
    }

    private fun lengthOfLastWord(s: String): Int {
        var count = 0
        var index = s.length - 1

        while (s[index] == ' ') {
            index--
        }

        while (index >= 0 && s[index] != ' ') {
            count++
            index--
        }

        return count
    }

    /**
     * Fun kotlin way to solve the problem.
     */
    private fun lengthOfLastWord2(s: String): Int {
        return s.trimEnd().substringAfterLast(' ').length
    }


}