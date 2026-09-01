import java.util.HashSet;

//pass
public class LongestSubstringWithoutRepeatingCharacters {
    

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charactersSeen = new HashSet<>();
        int left = 0;
        int right = 0;
        int longestSubstring = 0;
        while(right < s.length()){
            while(charactersSeen.contains(s.charAt(right))){
                charactersSeen.remove(s.charAt(left));
                left++;
            }
            charactersSeen.add(s.charAt(right));
            longestSubstring = Math.max(longestSubstring, right - left + 1);
            right++;
        }
        return longestSubstring;
    }

}
