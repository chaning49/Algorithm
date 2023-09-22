import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // s / n의 몫은 원소의 합이 s가 되는 수 중에서 가장 편차가 작은 숫자이다.
        int limit = s / n;
        
        // s / n이 0이면 최고의 집합을 구할 수 없으므로 -1
        if (limit == 0) {
            return new int[]{-1};
        }
        
        // 나머지가 0이면 같은 수를 연속으로 더해서 만들 수 있는 수이고 0이 아닌 경우에는 나머지 수만큼 1씩 증가한 최고 집합을 만들 수 있다.
        int iter = s % n;
        
        // 크기가 n인 배열을 만들고 s / n 값으로 모두 채운다.
        int[] answer = new int[n];
        Arrays.fill(answer, limit);
        
        // 나머지의 수만큼 1씩 증가
        for (int i = 0; i < iter; i++) {
            answer[n - i - 1]++;
        }
        
        return answer;
    }
}