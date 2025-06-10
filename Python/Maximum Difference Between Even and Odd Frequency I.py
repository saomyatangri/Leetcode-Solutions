class Solution(object):
    def maxDifference(self, s):
        """
        :type s: str
        :rtype: int
        """
        c = Counter(s)
        evens = [count for letter, count in c.items() if count % 2 == 0]
        odds = [count for letter, count in c.items() if count % 2 == 1]

        return max(odds) - min(evens)
        
