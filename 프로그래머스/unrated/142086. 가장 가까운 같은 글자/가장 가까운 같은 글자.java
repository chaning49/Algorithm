import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // s에 있는 알파벳과 가장 앞에 위치한 알파벳의 인덱스를 저장
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, s.indexOf(c));
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(c);
                map.put(c, i);
            }
        }
        
        return answer;
    }
}