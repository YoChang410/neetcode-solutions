import java.util.Stack;
import java.util.HashMap;

//pass
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        HashMap<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put(')', '(');
        matchingParentheses.put(']', '[');
        matchingParentheses.put('}', '{');
        for(char c : s.toCharArray()){
           if(matchingParentheses.containsKey(c)){// the character is a closing parentheses
                if(stack.isEmpty() || stack.pop() != matchingParentheses.get(c)){
                    return false;
                }
                
           }
           else{
            stack.push(c);
           }
        }
        return stack.isEmpty();
    }
}
