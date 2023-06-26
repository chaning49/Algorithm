import java.util.*;

class Solution {
    public int solution(String s) {
        // 정답 개수
        int answer = 0;
        
        // 첫 문자열 저장, 같은 문자 개수, 다른 문자 개수
        char x = s.charAt(0);
        int eqNum = 0;
        int diffNum = 0;
        
        // 같은 문자 개수 == 다른 문자 개수이면 분해해야 하므로 정답 개수 + 1 후 x를 해당 문자로 변경한다. 그 외의 경우에는 x와 현재 문자가 같은지 다른지에 따라 값을 각각 증가시켜준다.
        for (int i = 0; i < s.length(); i++) {
            if (eqNum == diffNum) {
                answer++;
                x = s.charAt(i);
            } 
            
            if (x == s.charAt(i))
                eqNum++;
            else
                diffNum++;
        }
            
        return answer;
    }
}