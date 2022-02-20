package leetcode.link;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_add_two_numbers {
    public static void main(String[] args) {
        ListNode l1 = init(new int[]{2, 4,3});
        ListNode l2 = init(new int[]{5,6,4});
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println(sum.val);
        while(sum.next != null){
            System.out.println(sum.val);
            sum = sum.next;
        }
        System.out.println(sum.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum_header = new ListNode((l1.val+ l2.val)%10);
        ListNode sum = sum_header;
        int next_val = (l1.val + l2.val)/10;
        while(l1.next !=null && l2.next !=null){
            l1=l1.next;
            l2 = l2.next;
            sum.next = new ListNode((l1.val + l2.val+next_val)%10);
            next_val = (l1.val + l2.val+next_val)/10;
            sum = sum.next;
        }
        while(l1.next != null){
            l1 = l1.next;
            sum.next = new ListNode((l1.val+next_val)%10);
            next_val = (l1.val + next_val) /10;
            sum = sum.next;
        }
        while(l2.next != null){
            l2 = l2.next;
            sum.next = new ListNode((l2.val+next_val)%10);
            next_val = (l2.val + next_val) /10;
            sum = sum.next;
        }
        if(next_val !=0){
            sum.next = new ListNode(next_val);
        }
        return sum_header;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode  init(int[] numbers){
        ListNode  header = new ListNode(numbers[0]);
        ListNode cur = header;
        for (int i = 1; i < numbers.length; i++) {
            cur.next = new ListNode(numbers[i]);
            cur = cur.next;
        }
        return header;
    }
}
