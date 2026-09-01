import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//pass

public class ThreeSum {
    
    public static void main(String[] args){
        ThreeSum test = new ThreeSum();
        System.out.println(test.threeSum(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        //debug
        //System.out.println("Sorted: ");
        //for(int i:nums) System.out.print(i + ", ");
        //System.out.println("\n\n");

        ArrayList<Integer> numAL = new ArrayList<Integer>();
        List<List<Integer>> allSets = new ArrayList<List<Integer>>();
        HashSet<HashMap<Integer, Integer>> existing = new HashSet<HashMap<Integer, Integer>>();
        for(int num : nums){
            numAL.add(num);
        }
        for(int i=0; i<numAL.size(); i++){
            ArrayList<Integer> removed = new ArrayList<Integer>(numAL);
            int total = removed.get(i);
            removed.remove(i);

            //debug 
            //System.out.println(removed);

            HashSet<ArrayList<Integer>> allPairs = fitIndicies(removed, total*-1);
            if(allPairs != null){
                for(ArrayList<Integer> pair : allPairs){
                    HashMap<Integer, Integer> thisSet = new HashMap<Integer, Integer>();
                    thisSet.put(total, 1);
                    if(thisSet.containsKey(pair.get(0))) thisSet.put(pair.get(0), 1+thisSet.get(pair.get(0)));
                    else thisSet.put(pair.get(0), 1);
                    if(thisSet.containsKey(pair.get(1))) thisSet.put(pair.get(1), 1+thisSet.get(pair.get(1)));
                    else thisSet.put(pair.get(1), 1);

                    if(!existing.contains(thisSet)){
                        ArrayList<Integer> thisList = new ArrayList<Integer>();
                        thisList.add(total);
                        thisList.add(pair.get(0));
                        thisList.add(pair.get(1));
                        allSets.add(thisList);
                        existing.add(thisSet);
                    }
                }

            }
        }
        return allSets;
    }

    public HashSet<ArrayList<Integer>> fitIndicies (ArrayList<Integer> available, int target){
        int left = 0;
        int right = available.size()-1;
        boolean pairsFound = false;
        HashSet<ArrayList<Integer>> allPairs = new HashSet<ArrayList<Integer>>();
        while(left < right){
            int sum = available.get(left) + available.get(right);
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(available.get(left));
                pair.add(available.get(right));
                allPairs.add(pair);
                pairsFound = true;
                left++;
                right--;
            }
            else if(sum < target){
                left ++;
            }
            else if(sum > target){
                right --;
            }
        }
        if(pairsFound) return allPairs;
        else return null;
    }
}
