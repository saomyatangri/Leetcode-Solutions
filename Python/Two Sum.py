class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        data = {}
        for i in range(len(nums)):
            data[nums[i]] = i
        
        for i in range(len(nums)):
            goal = target - nums[i]
            if (goal in data.keys() and data.get(goal) != i):
                return [i, data.get(goal)]
