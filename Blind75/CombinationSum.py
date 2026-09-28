from typing import List


class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        list.sort(nums)
        return self.createCombo(nums, target)
        
    def createCombo(self, nums: List[int], toAdd: int) ->List[List[int]]:
        ans = []
        for x in range(len(nums)):
            if nums[x] > toAdd:
                break
            elif nums[x] == toAdd:
                ans.append([nums[x]])
            else:
                for combo in self.createCombo(nums[x:], toAdd-nums[x]):
                    ans.append([nums[x]] + combo)
        return ans