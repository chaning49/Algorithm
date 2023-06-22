import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // String s를 배열로 변환
        String[] arr = s.split("");
        
        // 같은 알파벳이 들어오는지 검사할 빈 스택 생성
        Stack<String> stack = new Stack<> ();
        
        for (String a : arr) {
            // 스택이 비어있지 않고, 맨 위의 값이 a와 같으면 pop
            if (!stack.isEmpty() && stack.peek().equals(a)) {
                stack.pop();
            }
            //  그 외의 경우 a를 스택에 push
            else 
                stack.push(a);
        }
        return stack.size() == 0 ? 1 : 0;
    }
}