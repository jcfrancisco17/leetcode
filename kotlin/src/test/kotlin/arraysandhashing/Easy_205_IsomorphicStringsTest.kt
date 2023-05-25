package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)
 *
 */
class Easy_205_IsomorphicStringsTest {

    @Test
    fun testCase() {
        assertThat(isIsomorphic("egg", "add")).isTrue()
        assertThat(isIsomorphic("foo", "bar")).isFalse()
        assertThat(isIsomorphic("paper", "title")).isTrue()
        assertThat(isIsomorphic("badc", "baba")).isFalse()
    }

    /**
     * The trick here is that the mapping should be two-way, ie string "s" -> string "t" and string "t" -> string "s"
     */
    private fun isIsomorphic(s: String, t: String): Boolean {
        val mapST = mutableMapOf<Char, Char>()
        val mapTS = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val a = s[i]
            val b = t[i]

            if ((mapST.contains(a) && mapST[a] != b)
                || (mapTS.contains(b) && mapTS[b] != a)
            ) {
                return false
            }
            mapST[a] = b
            mapTS[b] = a
        }
        return true
    }

}