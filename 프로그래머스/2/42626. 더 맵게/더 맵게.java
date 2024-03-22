import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 섞어야 하는 최소 횟수
        int answer = 0;
        
        // 최소힙 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 힙에 scovile 값을 모두 넣기
        for (int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }
        
        // 반복하면서 모든 음식이 k 이상이 되도록 만든다.
        // 1. 루프문에서 heap.peek이 K 이상일 때, answer를 더하지 않고 즉시 0을 리턴하는가
        // 2. heap의 size가 2보다 작아 루프에서 탈출했을 때, heap.peek이 K 이상인지 확인 후 answer를 return 하는가
        while (minHeap.size() >= 2) {
            if (minHeap.peek() >= K) {
                break;
            }
            int min = minHeap.poll();
            int secMin = minHeap.poll();
            int mixed = min + secMin * 2;
            minHeap.offer(mixed);
            answer++;
        }
        
        // 만약 그렇지 못하면 -1 리턴 -> 반복하다가 원소가 하나만 남은 상황에서 k 이상이 아니면 -1
        if (minHeap.peek() < K) {
            return -1;
        } 
        
        return answer;
    }
}