package arraysandhashing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.sign

/**
 * [Question 29. Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)
 */
class Easy_929_UniqueEmailAddressesTest {

    @Test
    fun testCase() {
        assertThat(
            numUniqueEmails2(
                arrayOf(
                    "test.email+alex@leetcode.com",
                    "test.e.mail+bob.cathy@leetcode.com",
                    "testemail+david@lee.tcode.com"
                )
            )
        ).isEqualTo(2);
        assertThat(numUniqueEmails2(arrayOf("a@leetcode.com", "b@leetcode.com", "c@leetcode.com"))).isEqualTo(3);
    }

    private fun numUniqueEmails2(emails: Array<String>): Int {
        // split local and domain name
        // sanitize local name
        // combine local and domain name

        val realEmails = emails.map { email ->
            val split = email.split('@')
            val local = split[0].substringBefore('+').filter { it != '.' }
            val domain = split[1]
            local.plus("@").plus(domain)
        }.distinct()

        return realEmails.size
    }


}