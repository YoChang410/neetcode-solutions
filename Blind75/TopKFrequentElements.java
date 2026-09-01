import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
//pass
public class TopKFrequentElements {

    public  int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFrequencies = new HashMap<Integer, Integer>();
        for(int i:nums){
            if(!numFrequencies.containsKey(i)){
                numFrequencies.put(i, 0);
            }
            int newFreq = numFrequencies.get(i)+1;
            numFrequencies.put(i, newFreq);
        }


        HashMap<Integer, ArrayList<Integer>> frequentNums = new HashMap<Integer, ArrayList<Integer>>();
        Set<Map.Entry<Integer, Integer>> entries = numFrequencies.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries){
            if(!frequentNums.containsKey(entry.getValue())){
                frequentNums.put(entry.getValue(), new ArrayList<Integer>());
            }
            frequentNums.get(entry.getValue()).add(entry.getKey());
        }    
        int[] ans = new int[k];
        int currentFreq = nums.length;
        int numbersTaken = 0;
        while(numbersTaken < k){
            if(frequentNums.containsKey(currentFreq)){
                for(Integer num : frequentNums.get(currentFreq)){
                    ans[numbersTaken] = num;
                    numbersTaken++;
                    if(numbersTaken == k){
                        return ans;
                    }
                }
            }
            currentFreq--;
        }
        return ans;
    }
}
