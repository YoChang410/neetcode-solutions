import java.util.ArrayList;
import java.util.List;
//pass
public class EncodeAndDecodeString {

    public String encode(List<String> strs) {
        String ans = "";
        ans = ans + strs.size() + '.';
        for(String str : strs){
            ans = ans + str.length() + '.';
        }
        for(String str: strs){
            ans = ans + str;
        }
        return ans;
    }

    public List<String> decode(String str) {
        int totalIndex = 0;
        int numStrings=0;
        for(int i=0; i<str.length(); i++){
            char character = str.charAt(i);
            totalIndex++;
            if(character > 47 && character < 58){
                numStrings *= 10;
                numStrings += character - 48;
            }
            else{
                break;
            } 
        }
        ArrayList<Integer> stringLengths = new ArrayList<Integer>();
        for(int o=0; o<numStrings; o++){
            int length=0;
            for(int i=0; i<str.length(); i++){
                char character = str.charAt(totalIndex);
                totalIndex++;
                if(character > 47 && character < 58){
                    length *= 10;
                    length += character - 48;
                }
                else break;
            }
            stringLengths.add(length);
        }
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0; i<numStrings; i++){
            String smallStr = "";
            for(int o=0; o<stringLengths.get(i); o++){
                smallStr += str.charAt(totalIndex);
                totalIndex++;
            }
            ans.add(smallStr);
        }
        return ans;
    }
    
}
