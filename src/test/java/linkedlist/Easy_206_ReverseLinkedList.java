package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Question 206</a>
 *
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * </p>
 *
 * <pre>
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * </pre>
 */
class Easy_206_ReverseLinkedList {

    @Test
    void testCases() {
        assertThat(Solution.reverseListIterative(
                new ListNode<>(1,
                        new ListNode<>(2,
                                new ListNode<>(3,
                                        new ListNode<>(4,
                                                new ListNode<>(5)
                                        )
                                )
                        )
                )
        ).toList()).isEqualTo(List.of(5, 4, 3, 2, 1));

        assertThat(Solution.reverseListIterative(
                new ListNode<>(1,
                        new ListNode<>(2)
                )
        ).toList()).isEqualTo(List.of(2, 1));

        assertThat(Solution.reverseListIterative(null)).isNull();
    }

    /**
     * <pre>
     * Given:
     *
     * prevNode        currNode        nextNode
     * 1        /----> 2        /----> 3        /----> 4        /----> null
     * next ---/       next ---/       next ---/       next ---/
     *
     * - Assign currNode.next to nextNode to preserve the reference
     * - Point currNode.next to prevNode
     *
     * prevNode        currNode        nextNode
     * 1    <----\     2               3        /----> 4        /----> null
     * next       \--- next            next ---/       next ---/
     *
     * - Move the pointers to the right
     * - The new prevNode takes the value of the currNode
     * - The new currNode takes the value of the nextNode
     *
     *                 prevNode        currNode        nextNode
     * 1    <----\     2               3        /----> 4        /----> null
     * next       \--- next            next ---/       next ---/
     *
     * - Repeat until currNode is null
     *
     *                 prevNode        currNode        nextNode
     * 1    <----\     2    <----\     3               4        /----> null
     * next       \--- next       \--- next            next ---/
     * </pre>
     */
    private static class Solution {
        private static ListNode<Integer> reverseListIterative(ListNode<Integer> head) {
            ListNode<Integer> prevNode = null;
            ListNode<Integer> currNode = head;

            while (currNode != null) {
                ListNode<Integer> nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }

            return prevNode;
        }
    }

    /**
     * ListNode definition.
     *
     * @param <T>
     */
    private static class ListNode<T> {

        T val;
        ListNode<T> next;

        ListNode() {
        }

        ListNode(T val) {
            this.val = val;
        }

        ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        List<T> toList() {
            ListNode<T> current = this;

            List<T> list = new ArrayList<>();
            while (current != null) {
                list.add(current.val);
                current = current.next;
            }
            return list;
        }

    }
}
