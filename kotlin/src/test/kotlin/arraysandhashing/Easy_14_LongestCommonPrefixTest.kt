package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * [Question 14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 */
class Easy_14_LongestCommonPrefixTest {

    @Test
    fun testCase() {
        assertThat(longestCommonPrefix(arrayOf("flower", "flow", "flight"))).isEqualTo("fl");
        assertThat(longestCommonPrefix(arrayOf("flower", "flow", ""))).isEqualTo("");
        assertThat(longestCommonPrefix(arrayOf("dog", "racecar", "car"))).isEqualTo("");
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = ""

        strs.minBy { it.length }!!                      // finds the shortest string
            .forEachIndexed { index, char ->            // iterate through the characters of the shortest string
                if (strs.all { it[index] == char }) {   // check the strings if the characters are the same for the given index
                    prefix += char
                } else
                    return prefix
            }

        return prefix
    }
}