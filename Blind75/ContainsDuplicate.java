import java.util.HashMap;
//pass

class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> existing = new HashMap<Integer, Boolean>();
        for(int i : nums){
            if(existing.containsKey(i)){
                return true;
            }
            else existing.put(i, true);
        }
        return false;
    }
}