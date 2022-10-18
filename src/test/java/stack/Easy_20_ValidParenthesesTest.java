package stack;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Question 20</a>
 *
 * <p>Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.</p>
 *
 * <p>An input string is valid if:</p>
 * <ul>
 *     <li>Open brackets must be closed by the same type of brackets.</li>
 *     <li>Open brackets must be closed in the correct order.</li>
 *     <li>Every close bracket has a corresponding open bracket of the same type.</li>
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * </pre>
 *
 * <pre>
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * </pre>
 *
 * <pre>
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * </pre>
 *
 * <pre>
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * </pre>
 */
class Easy_20_ValidParenthesesTest {

    @Test
    void testCases() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Solution.isValid("()")).isTrue();
            softly.assertThat(Solution.isValid("()[]{}")).isTrue();
            softly.assertThat(Solution.isValid("{[]}")).isTrue();
            softly.assertThat(Solution.isValid(")(")).isFalse();
            softly.assertThat(Solution.isValid("(]")).isFalse();
            softly.assertThat(Solution.isValid("([)]")).isFalse();
            softly.assertThat(Solution.isValid("({[)")).isFalse();
        });
    }

    /**
     * <p>
     * The idea here is to push the parentheses into a stack and pop matching pairs as they are found. If the stack is
     * empty at the end of the iteration, the parentheses are valid, otherwise the parentheses are invalid.
     * </p>
     * </p>
     * By intuition, one might make a map of the parentheses where the key are the opening parentheses. However, after
     * trying it out, it seems making the closing parentheses the key is easier to implement.
     * </p>
     */
    private static class Solution {
        static boolean isValid(String s) {
            var pairs = Map.of(')', '(', ']', '[', '}', '{');
            var stack = new ArrayDeque<Character>();

            for (char c : s.toCharArray()) {
                if (stack.isEmpty() && pairs.containsKey(c)) {
                    return false;
                } else if (!stack.isEmpty() && pairs.get(c) == stack.getFirst()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
}
