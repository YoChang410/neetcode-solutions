import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
//pass
public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, ArrayList<String>> anagrams = new HashMap<ArrayList<Integer>, ArrayList<String>>();
        for(String str : strs){
            int[] lettercount = new int[26];
            ArrayList<Integer> lettercountAL = new ArrayList<Integer>();
            for(int i=0; i<str.length(); i++){
                char letter = str.charAt(i);
                lettercount[letter-97] ++;
            }
            for(int i : lettercount){
                lettercountAL.add(i);
            }
            if(anagrams.containsKey(lettercountAL)){
                anagrams.get(lettercountAL).add(str);
            }
            else {
                anagrams.put(lettercountAL, new ArrayList());
                anagrams.get(lettercountAL).add(str);
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        Set<Map.Entry<ArrayList<Integer>, ArrayList<String>>> entries = anagrams.entrySet();
        for (Map.Entry<ArrayList<Integer>, ArrayList<String>> entry : entries) {
            ans.add(entry.getValue());
        }
        return ans;
    }

}
