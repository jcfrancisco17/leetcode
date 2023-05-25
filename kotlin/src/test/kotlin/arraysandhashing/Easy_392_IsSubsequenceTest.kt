package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Easy_392_IsSubsequenceTest {

    @Test
    fun testCase() {
        assertThat(subsequence("abc", "ahbgdc")).isTrue()
        assertThat(subsequence("axc", "ahbgdc")).isFalse()
        assertThat(subsequence("aaaaaa", "bbaaaa")).isFalse()
        assertThat(subsequence("", "ahbgdc")).isTrue()
    }

    private fun subsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0

        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
            }
            j++
        }
        return i == s.length
    }
}