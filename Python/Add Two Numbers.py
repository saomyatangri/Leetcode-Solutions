# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        first = ""
        sec = ""
        carry = 0
        result = ListNode()
        head = result
        while (l1 is not None or l2 is not None):
            if (l1 is not None and l2 is not None):
                sum = l1.val + l2.val + carry
            elif (l1 is not None):
                sum = l1.val + carry
            else:
                sum = l2.val + carry
            
            next_val = sum % 10
            carry = 1 if (sum/10 > 0) else 0
            l1 = None if l1 is None else l1.next
            l2 = None if l2 is None else l2.next
            print("sum = %d, next_val = %d, carry = %d" % (sum, next_val, carry))
            result.next = ListNode(next_val)
            result = result.next 
            
        if (carry):
            result.next = ListNode(1)
        
        return head.next
        
        
        
