import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long checkNum = 0;
        
        // 최대힙에 works 값을 모두 삽입
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            maxHeap.add(w);
            checkNum += (long) w;
        }
        
        // works에 있는 시간이 n보다 작은 경우는 남은 작업량이 없는 경우이므로 0을 반환
        if (checkNum < n) {
            return 0;
        }
        
        // 최대값을 1씩 줄여가며 n회 수행
        while (n > 0) {
            int num = maxHeap.poll();
            if (num > 0) {
                maxHeap.add(--num);
            }
            n--;
        }
        
        // 각 자리의 제곱값을 answer에 더한다.
        while (!maxHeap.isEmpty()) {
            long temp = maxHeap.poll();
            answer += temp * temp;
        }
        
        return answer;
    }
}