import java.util.HashSet;
//pass 
public class LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int ans = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int currentLength = 1;
                for(int i=num+1; i<num+nums.length; i++){
                    if(set.contains(i)){
                        currentLength++;
                    }
                    else break;
                }
                ans = Math.max(ans, currentLength);
            }
        }
        return ans;
    }
}
