import java.util.HashMap;
//pass
public class MininumWindowSubstring {

    public static void main(String[] args) { 
        MininumWindowSubstring mininumWindowSubstring = new MininumWindowSubstring();
        System.out.println(mininumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetCharacterCounts = new HashMap<>();
        for(char c : t.toCharArray()){
            targetCharacterCounts.put(c, targetCharacterCounts.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> windowCharacterCounts = new HashMap<>();
        int left = 0;
        int right = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;
        while(right < s.length()){
            windowCharacterCounts.put(s.charAt(right), windowCharacterCounts.getOrDefault(s.charAt(right), 0) + 1);
            while(isWindowValid(windowCharacterCounts, targetCharacterCounts)){
                if(right - left + 1 < minWindowLength){
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }
                windowCharacterCounts.put(s.charAt(left), windowCharacterCounts.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        if(minWindowLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minWindowStart, minWindowStart + minWindowLength);
    }

    public boolean isWindowValid(HashMap<Character, Integer> windowCharacterCounts, HashMap<Character, Integer> targetCharacterCounts){
        for(char c : targetCharacterCounts.keySet()){
            if(windowCharacterCounts.getOrDefault(c, 0) < targetCharacterCounts.get(c)){
                return false;
            }
        }
        return true;
    }
}
