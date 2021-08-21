class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        idx = 0
        while (idx < len(s)/2):
            tmp = s[idx]
            s[idx] = s[-(idx+1)]
            s[-(idx+1)] = tmp
            idx += 1
            
        
