import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // maxHeap으로 최대값을 처리
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities)
            pq.offer(p);
        
        // pq의 맨 처음 값이 최대값이 되므로 차례로 최대값을 제거하면서 location에 위치한 값이 몇 번째인지 체크
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (i == location)
                        return answer;
                }
            }
        }
        
        return answer;
    }
}