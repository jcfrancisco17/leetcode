package arraysandhashing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/baseball-game/">Question 682</a>
 *
 * <p>You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.</p>
 *
 * <p>You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:</p>
 *
 * <pre>
 * - An integer x.
 *   - Record a new score of x.
 * - '+'
 *   - Record a new score that is the sum of the previous two scores.
 * - 'D'
 *   - Record a new score that is the double of the previous score.
 * - 'C'
 *   - Invalidate the previous score, removing it from the record.
 * </pre>
 *
 * <p>Return the sum of all the scores on the record after applying all the operations.</p>
 *
 * <p>The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.</p>
 */
class Easy_682_BaseballGameTest {

    @Test
    void testCases() {
        assertThat(Solution.calPoints(new String[]{"5", "2", "C", "D", "+"})).isEqualTo(30);
        assertThat(Solution.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})).isEqualTo(27);
        assertThat(Solution.calPoints(new String[]{"1", "C"})).isZero();
    }

    /**
     * Requires a list of scores.
     * Match the operations to the appropriate statements.
     * If the operation is a number, add it to the list of scores. Otherwise, perform the operation.
     */
    private static class Solution {
        private static int calPoints(String[] operations) {
            var scores = new ArrayList<Integer>();
            for (String operation : operations) {
                switch (operation) {
                    case "C" -> scores.remove(scores.size() - 1);
                    case "D" -> scores.add(scores.get(scores.size() - 1) * 2);
                    case "+" -> scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
                    default -> scores.add(Integer.valueOf(operation));
                }
            }

            return scores.stream().reduce(0, Integer::sum);
        }
    }
}
