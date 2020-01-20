package leetcode;

import java.util.Arrays;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @Author asa.x
 * @Date: Created at 17:19 2020/1/20.
 */
public class LC1290 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * <p>
     * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
     * The linked list holds the binary representation of a number.
     * <p>
     * Return the decimal value of the number in the linked list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,0,1]
     * Output: 5
     * Explanation: (101) in base 2 = (5) in base 10
     * Example 2:
     * <p>
     * Input: head = [0]
     * Output: 0
     * Example 3:
     * <p>
     * Input: head = [1]
     * Output: 1
     * Example 4:
     * <p>
     * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * Output: 18880
     * Example 5:
     * <p>
     * Input: head = [0,0]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The Linked List is not empty.
     * Number of nodes will not exceed 30.
     * Each node's value is either 0 or 1.
     */
    public int getDecimalValue(ListNode head) {
        int[] numbers = new int[30];
        int length = 0;
        while (head != null) {
            numbers[length] = head.val;
            length++;
            head = head.next;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = result + numbers[i] * pow(2, length - 1 - i);
        }
        return result;
    }

    private int pow(int background, int index) {
        int result = 1;
        for (int i = 0; i < index; i++) {
            result = result * background;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LC1290 lc1290 = new LC1290();
        int[] test1 = {1,0,1};
        ListNode head = fromArray(test1);
        System.out.println(new LC1290().getDecimalValue(head));

    }

    public static ListNode fromArray(int[] elements) {
        ListNode head = new ListNode(elements[0]);
        ListNode pre = head;
        int index = 1;
        while (index < elements.length) {
            ListNode cursor = new ListNode(elements[index++]);
            pre.next = cursor;
            pre = cursor;
        }
        return head;
    }
}