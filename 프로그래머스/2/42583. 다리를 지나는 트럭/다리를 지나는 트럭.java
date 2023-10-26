import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리 위에 올라간 트럭의 총 무게를 확인할 변수 선언
        int currWeight = 0;
        
        // 트럭을 저장할 Queue 선언
        Queue<Integer> bridgeQueue = new LinkedList<>();
        
        // 여러 대의 트럭을 하나씩 다리에 올리면서 비교
        for (int tw : truck_weights) {
            while (true) {
                if (bridgeQueue.isEmpty()) { // 다리에 트럭이 없으면 트럭을 하나 올리고 시간 증가
                    bridgeQueue.add(tw);
                    currWeight += tw;
                    answer++;
                    break;
                } else if (bridgeQueue.size() == bridge_length) { // 다리 위에 있는 트럭의 개수가 다리 길이와 같으면 맨 앞에 있는 트럭은 빠져나간다.
                    currWeight -= bridgeQueue.poll();
                } else { // 다리 위에 있는 트럭이 다리 길이보다 작은 경우
                    if (tw + currWeight > weight) { // 다리 위에 있는 트럭의 무게 + 현재 대기중인 트럭의 무게가 최대 무게보다 큰 경우
                        bridgeQueue.add(0);
                        answer++;
                    } else { // 다리 위에 있는 트럭의 무게 + 현재 대기중인 트럭의 무게가 최대 무게보다 작거나 같은 경우
                        bridgeQueue.add(tw);
                        currWeight += tw;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}