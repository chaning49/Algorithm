import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 회전시킬 문자열 저장
        String rotate = s;
        
        // 문자열의 길이만큼만 회전
        for (int i = 0; i < s.length(); i++) {
            // checkStr이 true이면 올바른 괄호 문자열 개수 증가
            if (checkStr(rotate)) answer++;
            // 문자열 회전
            rotate = rotate.substring(1, s.length()) + rotate.charAt(0);
        }
        
        return answer;
    }
    
    public boolean checkStr(String s) {
        // 문자열을 저장할 스택
        Stack<Character> stk = new Stack<> ();
        
        // 문자열의 각 문자를 확인하면서 괄호가 올바른지 확인
        for (int i = 0; i < s.length(); i++) {
            // 스택이 비어있는 경우 push
            if (stk.isEmpty()) stk.push(s.charAt(i));
            else {
                // 현재 문자가 닫힌 괄호인 경우, 스택의 최상위 괄호와 짝이 맞는지 확인 후 맞으면 pop 아니면 false 반환
                if (s.charAt(i) == ')') {
                    if (stk.peek() == '(') stk.pop();
                    else return false;
                } else if (s.charAt(i) == '}') {
                    if (stk.peek() == '{') stk.pop();
                    else return false;
                } else if (s.charAt(i) == ']') {
                    if (stk.peek() == '[') stk.pop();
                    else return false;
                } else stk.push(s.charAt(i));
            }
        }
        // 모든 문자를 확인한 후 스택이 비어있는지 확인하여 올바른 괄호 문자열인지 판단
        if (stk.isEmpty()) return true;  // 스택이 비어있으면 true 반환
        else return false;  // 스택이 비어있지 않으면 false 반환
    }
}