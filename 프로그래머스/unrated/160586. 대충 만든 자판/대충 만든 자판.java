import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> alpha = new HashMap<>();
        int[] answer = new int[targets.length];
        
        // 정답 배열 초기화
        Arrays.fill(answer, 0);
        
        // keymap에 있는 알파벳이 가장 빠르게 등장하는 순서를 알파벳 map에 저장
        for (String key : keymap) {
            char[] keyArr = key.toCharArray();
            for (int i = 0; i < keyArr.length; i++) {
                if(!alpha.containsKey(keyArr[i]) || i < alpha.get(keyArr[i])) {
                    alpha.put(keyArr[i], i + 1);
                }
            }
        }
        
        // target에 있는 알파벳을 순회하면서 정답을 저장
        for (int i = 0; i < targets.length; i++) {
            char[] targetArr = targets[i].toCharArray();
            for (char t : targetArr) {
                if (!alpha.containsKey(t)) {
                    answer[i] = 0;
                    break;
                } else {
                    answer[i] += alpha.get(t);
                }
            }
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
            
        return answer;
    }
}