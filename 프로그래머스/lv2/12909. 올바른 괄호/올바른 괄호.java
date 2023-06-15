import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();
        
        // i번째 인덱스의 char가 '('이면 push, 아닌 경우 pop을 해주는데 이 때 스택이 빈 경우 false return
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                stk.push('(');
            else {
                if (stk.isEmpty()) 
                    answer = false;
                else 
                    stk.pop();
            }
        }
        
        // 전체를 돌고 나서 마지막에 '('가 들어오는 경우까지 체크해주기 위해 한번 더 확인
        if (stk.size() != 0) 
            answer = false;

        return answer;
    }
}