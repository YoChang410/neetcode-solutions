import java.util.HashMap;
import java.util.Collections; 

//pass
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> characterCounts = new HashMap<>();
        int left = 0;
        int right = 0;
        int longestSubstring = 0;
        while(right < s.length()){
            characterCounts.put(s.charAt(right), characterCounts.getOrDefault(s.charAt(right), 0) + 1);
            while(right - left + 1 - Collections.max(characterCounts.values()) > k){
                characterCounts.put(s.charAt(left), characterCounts.get(s.charAt(left)) - 1);
                left++;
            }
            longestSubstring = Math.max(longestSubstring, right - left + 1);
            right++;
        }
        return longestSubstring;
    }
}
