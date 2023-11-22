import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // Map에 귤의 크기, 개수를 저장
        Map<Integer, Integer> gyul = new HashMap<>();
        for (int t : tangerine) {
            if (!gyul.containsKey(t)) {
                gyul.put(t, 1);
            } else {
                gyul.put(t, gyul.get(t) + 1);
            }
        }
        
        // 귤의 개수만을 저장 후 sort
        int[] sortedTan = new int[gyul.size()];
        int i = 0;
        for (int g : gyul.keySet()) {
            sortedTan[i] = gyul.get(g);
            i++;
        }
        Arrays.sort(sortedTan);
        
        // 가장 개수가 많은 귤을 기준으로 k개를 없앨 수 있도록 제거
        i = sortedTan.length - 1;
        while (k > 0) {
            k -= sortedTan[i--];
            answer++;
        }
        
        return answer;
    }
}