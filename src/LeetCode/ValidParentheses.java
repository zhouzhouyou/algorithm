package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put(')','(');
        map.put('[',']');
        map.put(']','[');
        map.put('{','}');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) stack.push(c);
            else if (stack.peek() == map.get(c)) stack.pop();
            else stack.push(c);
        }
        return stack.empty();
    }
}
