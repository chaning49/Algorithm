import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int size = 0;
        
        // 스택 선언
        Stack<Integer> stk = new Stack<>();
        
        // 스택의 마지막 값과 arr의 원소를 비교해서 같은 숫자이면 pass
        for (int i = 0; i < arr.length; i++) {
            if (!stk.isEmpty() && stk.peek() == arr[i]) {
                continue;
            } else {
                stk.push(arr[i]);
                size++;
            }
        }
        
        // stack을 배열로 변환
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[size - i - 1] = stk.pop();
        }
        
        return answer;
    }
}