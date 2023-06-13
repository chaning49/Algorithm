import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();
        
        // k 크기만큼의 숫자를 저장할 최소 힙
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        // k번 동안 score의 값을 체크하고, k < score.length인 경우 다른 조건으로 동작
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                minHeap.offer(score[i]);
                ansList.add(minHeap.peek());
            } else {
                if (score[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(score[i]);
                } 
                ansList.add(minHeap.peek());
            }
        }
        
        // 리스트를 배열로 바꿔준다.
        answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
}