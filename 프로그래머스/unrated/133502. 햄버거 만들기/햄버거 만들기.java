import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();  // 재료들을 저장할 스택 생성
        int cnt = 0;  // 현재 스택에 쌓인 재료의 개수를 세는 변수
        int answer = 0;  // 특정 조합의 재료가 몇 번 제거되었는지 세는 변수

        for (int i : ingredient) {  // 주어진 재료들을 하나씩 반복
            stack.push(i);  // 재료를 스택에 넣음
            cnt++;  // 스택에 재료를 넣었으니 개수 증가

            // 스택에 적어도 4개의 재료가 있고, 최근 4개의 재료가 1, 3, 2, 1 순서라면
            if (cnt >= 4 && stack.get(cnt - 1) == 1
                && stack.get(cnt - 2) == 3
                && stack.get(cnt - 3) == 2
                && stack.get(cnt - 4) == 1) {
                stack.pop();  // 가장 최근에 넣은 재료 제거
                stack.pop();  // 그 다음으로 최근에 넣은 재료 제거
                stack.pop();  // 3번째로 최근에 넣은 재료 제거
                stack.pop();  // 4번째로 최근에 넣은 재료 제거
                cnt -= 4;  // 재료 4개를 제거했으니 개수 4 감소
                answer++;  // 조건에 맞게 재료를 제거한 횟수 증가
            }
        }
        return answer;  // 특정 조합의 재료가 제거된 횟수 반환
    }
}
