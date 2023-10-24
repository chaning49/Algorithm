import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        // n, m
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 1부터 n까지 순서를 저장할 덱을 선언
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dq.offer(i + 1);
        }

        // 뽑아야 하는 수 나열하기
        int[] numbers = new int[m];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        // numbers의 앞 숫자부터 차례대로 몇 회의 좌 또는 우 이동이 일어나는지 찾기
        for (int i = 0; i < m; i++) {
            int currNum = numbers[i];
            int idx = checkIdx(dq, currNum);

            String direction = checkDirection(idx, dq.size() - idx);

            if (direction.equals("L")) {
                answer += moveLeft(dq, idx);
            } else {
                answer += moveRight(dq, dq.size() - idx);
            }

            if (!dq.isEmpty() && dq.peek() == currNum) {
                dq.pollFirst();
            }
        }

        System.out.println(answer);
    }

    private static String checkDirection(int stIdx, int endIdx) {
        if (stIdx < endIdx) {
            return "L";
        } else {
            return "R";
        }
    }

    private static int moveLeft(Deque<Integer> dq, int idx) {
        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            dq.addLast(dq.pollFirst());
            cnt++;
        }
        return cnt;
    }

    private static int moveRight(Deque<Integer> dq, int idx) {
        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            dq.addFirst(dq.pollLast());
            cnt++;
        }
        return cnt;
    }

    private static int checkIdx(Deque<Integer> dq, int target) {
        int i = 0;
        for (Integer n : dq) {
            if (n == target) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
