package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Easy_242_ValidAnagramTest {

    @Test
    fun testCase() {
        assertThat(isAnagram("anagram", "nagaram")).isTrue()
        assertThat(isAnagram("cat", "rat")).isFalse()
    }

    private fun isAnagram(s: String, t: String): Boolean {
        val array = Array(26) { 0 }

        for (index in s.indices) {
            array[s[index] - 'a']++
            array[t[index] - 'a']--
        }

        return array.all { it == 0 }
    }

}