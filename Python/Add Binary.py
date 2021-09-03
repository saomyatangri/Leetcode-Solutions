class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        output = ""
        carry = 0
        
        i = -1
        max = len(a) if len(a) > len(b) else len(b)
        #print(max)
        while (i >= -max):
            if (i >= -len(a) and i >= -len(b)):
                sum = int(a[i]) + int(b[i]) + carry
                #print("a[i] = %d, b[i] = %d" % (int(a[i]), int(b[i])))
            elif (i >= -len(a)):
                sum = int(a[i]) + carry
                #print("a[i] = %d" % int(a[i]))
            elif (i >= -len(b)):
                sum = int(b[i]) + carry
                #print("b[i] = %d" % int(b[i]))
            #print("sum = %d\n\n\n" % sum)
            carry = True if sum > 1 else False
            if (sum%2 == 1):
                output = "1" + output
            else:
                output = "0" + output
            i -= 1
        
        if (carry):
            output = "1" + output
            
        return output
        
