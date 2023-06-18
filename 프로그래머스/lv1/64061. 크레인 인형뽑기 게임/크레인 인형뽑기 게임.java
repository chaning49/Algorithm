import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 아래부터 차례로 쌓아가는 방식이므로 스택을 선택
        Stack<Integer> stack = new Stack<>();

        // 크레인을 한 칸씩 탐색하면서 인형이 있는지 찾고, 바구니에 담아 로직에 따라 처리한다.
        for (int i : moves) {
            for (int j = 0; j < board.length; j++) {
                // board의 값이 0이 아닐 때
                if (board[j][i - 1] != 0) {
                    // 스택이 빈 경우, board의 특정 값을 스택에 push
                    if (stack.isEmpty()) {
                        stack.push(board[j][i - 1]);
                    }
                    // 스택에 값이 있는 경우, 스택의 맨 위에 위치한 값과 board의 특정 값이 같으면 pop 후 사라진 인형의 개수인 2를 더한다.
                    else if (stack.peek() == board[j][i - 1]) {
                        stack.pop();
                        answer += 2;
                    }
                    // 만약 스택이 비어있지는 않지만 스택의 맨 위에 위치한 값과 board의 특정 값이 다르면 push
                    else 
                        stack.push(board[j][i - 1]);
                    // 스택에 push가 되었든, pop이 되었든 board에서 꺼낸 값이므로 해당 위치의 값을 0으로 변경해준다.
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
