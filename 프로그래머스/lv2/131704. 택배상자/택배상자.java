import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> orderIdxMap = new HashMap<>();
        
        // order의 값과 순서를 map에 저장
        for (int i = 0; i < order.length; i++) {
            orderIdxMap.put(order[i], i);
        }
        
        // 현재 idx(기본 컨테이너 벨트에서 꺼낼 수 있는 상자 번호)와 idx(order에 들어있는 상자 번호)
        int currentIdx = 1;
        int nextOrderIdx = 0;
        
        while (currentIdx <= order.length) {
            // 현재 idx에 해당하는 상자 번호가 order의 값과 같은지 확인 후, stack(임시 보관 컨테이너)를 살핀다.
            if (orderIdxMap.get(currentIdx) == nextOrderIdx) {
                answer++;
                currentIdx++;
                nextOrderIdx++;
                while (!stack.isEmpty() && orderIdxMap.get(stack.peek()) == nextOrderIdx) {
                    stack.pop();
                    answer++;
                    nextOrderIdx++;
                }
            } else { // 다르면 stack에 push 후 인덱스 증가
                stack.push(currentIdx);
                currentIdx++;
            }
        }
        
        return answer;
    }
}