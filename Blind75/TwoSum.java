import java.util.HashMap;
//pass
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> existing = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            existing.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            if(existing.containsKey(target-nums[i]) && i != existing.get(target-nums[i])){
                return new int[]{i, existing.get(target-nums[i])};
            }
        }
        return null;
    }

}
