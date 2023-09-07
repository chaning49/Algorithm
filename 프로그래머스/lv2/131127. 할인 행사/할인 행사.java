import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // Map에 want에 있는 목록과 개수를 함께 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 슬라이딩 윈도우 - 정답 체크를 위한 Map
        Map<String, Integer> window = new HashMap<>();
        
        // 첫 10일의 discount를 window에 저장
        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        
        // 맨 앞에 위치한 물건, 맨 뒤에 위치한 물건을 한 칸씩 움직이면서 정답을 찾는다.
        for (int i = 0; i + 10 <= discount.length; i++) {
            if (isMatched(wantMap, window)) {
                answer++;
            }
            
            // 맨 앞에 위치한 물건을 빼준다.
            window.put(discount[i], window.get(discount[i]) - 1);
            if (window.get(discount[i]) == 0) {
                window.remove(discount[i]);
            }
            
            // 맨 뒤에 위치한 물건을 추가한다.
            if (i + 10 < discount.length) {
                window.put(discount[i + 10], window.getOrDefault(discount[i + 10], 0) + 1);
            }
        }
        
        return answer;
    }
    
    // wantMap에 있는 key-value의 값이 정확하게 일치하는 경우에만 true 반환
    private boolean isMatched(Map<String, Integer> wantMap, Map<String, Integer> window) {
        for (String key : wantMap.keySet()) {
            if (!window.containsKey(key) || window.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}