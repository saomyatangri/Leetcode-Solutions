/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; int sum = 0;
        ListNode output = new ListNode(0);
        ListNode node = output;

        while (l1 != null || l2 != null || carry > 0) { 
            int l1Value = l1 != null ? l1.val : 0;
            int l2Value = l2 != null ? l2.val : 0; 
            sum = l1Value + l2Value + carry;
            node.val = sum % 10;

            carry = sum / 10;
            l1 = l1 != null ? l1.next : null; 
            l2 = l2 != null ? l2.next : null; 

            if (l1 != null || l2 != null || carry > 0) {
                node.next = new ListNode(0);
                node = node.next;
            }            
        }
        return output;
    }
}
