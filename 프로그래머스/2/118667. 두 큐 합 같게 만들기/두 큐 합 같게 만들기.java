import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 총 횟수
        int answer = 0;
        
        // 큐 선언
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // queue1과 queue2가 각각 가져야 하는 값을 설정(총합 / 2)
        long sumOne = 0;
        long sumTwo = 0;
        for (int i = 0; i < queue1.length; i++) {
            sumOne += (long) queue1[i];
            sumTwo += (long) queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        // 총합이 홀수이면 정답을 구할 수 없다.
        if ((sumOne + sumTwo) % 2 == 1) {
            return -1;
        }
        
        long target = (sumOne + sumTwo) / 2;
        
        // target과 값이 같아질 때까지 반복하면서 총합이 더 큰쪽에서 값을 pop하고 작은 쪽으로 push한다.
        // 만약 한쪽 큐가 비는 상황이 생기면 정답이 없는 것이므로 -1
        // 최대로 while문을 순회하는 횟수는 queue의 2배이다. (queue1과 queue2의 크기가 같기 때문에 최악의 경우를 봐도 원소를 한쪽으로 모두 옮기는 작업이 총 2회이다.) -> 하지만 실제로 *특정 테스트 케이스에서 2 * queue1.length를 넘어가는 경우가 생긴다. 총 반복 횟수가 2 *queue.length < 반복횟수 < 3 * queue1.length인 경우가 있다. 그래서 while문의 반복 횟수는 3 * queue1.length로 해주어야 한다.
        while (answer < 3 * queue1.length) {
            if (sumOne == target) { // 정답인 경우 바로 return
                return answer;
            }
            if (sumOne > sumTwo) {
                sumOne -= q1.peek();
                sumTwo += q1.peek();
                q2.offer(q1.poll());
            } else if (sumOne < sumTwo) {
                sumTwo -= q2.peek();
                sumOne += q2.peek();
                q1.offer(q2.poll());
            }
            answer++;
        }
        
        return -1;
    }
}