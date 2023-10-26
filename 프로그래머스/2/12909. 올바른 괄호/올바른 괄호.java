import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 괄호를 저장할 스택
        Stack<Character> stk = new Stack<>();
        
        // 문자열 s를 하나씩 체크
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else {
                if (!stk.isEmpty()) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        
        // 스택에 괄호가 남아 있으면 false;
        if (!stk.isEmpty()) {
            return false;
        }

        return answer;
    }
}