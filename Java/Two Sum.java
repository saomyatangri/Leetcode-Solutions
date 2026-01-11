/* My new solution, only one pass of the array and more professional output handling */
import java.util.HashMap;
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer wantedKey = map.get(target-nums[i]);
            if (wantedKey != null) {
                return new int[]{wantedKey, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }    
}

/* My previous solution, not as efficient but still has the same O(N) as the new one  */

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             map.put(nums[i], i);
//         }
//         int result[] = new int[2];
//         for (int i = 0; i < nums.length; i++) {
//             int goal = target - nums[i];
//             if (map.containsKey(goal) && map.get(goal) != i) {
//                 result[0] = i;
//                 result[1] = map.get(goal);
//                 return result;
//             }
//         }
//         return result;
//     }
// }
