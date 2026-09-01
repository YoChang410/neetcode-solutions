//pass
public class ProductsofArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int totalproduct = 1;
        int numZeros = 0;
        for(int num : nums){
            if(num == 0){
                numZeros ++;
            }
            else {
                totalproduct *= num;
            }
        }
        int[] ans = new int[nums.length];
        for(int i=0; i<ans.length; i++){
            if(numZeros > 1){
                ans[i] = 0;
            }
            else if(numZeros == 1){
                if(nums[i] == 0){
                    ans[i] = totalproduct;
                }
                else ans[i] = 0;
            }
            else{
                ans[i] = totalproduct / nums[i];
            }
        }
        return ans;
    }
}
