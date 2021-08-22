class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        words = s.split(" ")
        result = ""
        for word in reversed(words):
            if word:
                result += word + " "
        return result.strip()
