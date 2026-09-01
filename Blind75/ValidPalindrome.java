import java.util.ArrayList;
//pass
public class ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        ArrayList<Character> cleaned = cleanString(s);
        for(int i=0; i<cleaned.size(); i++){
            if(cleaned.get(i) != cleaned.get(cleaned.size()-i-1)) return false;
        }
        return true;
    }
    public ArrayList<Character> cleanString(String s){
        ArrayList<Character> ans = new ArrayList<Character>();
        for(int i=0; i<s.length(); i++){
            char target = s.charAt(i);
            if((target >= '0' && target<= '9') || (target>='a' && target<='z') || (target >= 'A' && target <= 'Z')){
                if(target>='a' && target<='z'){
                    ans.add(Character.toUpperCase(target));
                }
                else ans.add(target);
            }
        }
        return ans;
    }
}
