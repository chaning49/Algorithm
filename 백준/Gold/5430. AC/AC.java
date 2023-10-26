import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test 개수
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 입력 받기
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine().replace("[", "").replace("]", "");

            Deque<String> dq;
            if (n > 0) {
                dq = new LinkedList<>(Arrays.asList(str.split(",")));
            } else {
                dq = new LinkedList<>();
            }

            // 에러와 뒤집기를 체크할 boolean
            boolean isError = false;
            boolean isReversed = false;

            // c가 R이면 뒤집기 ON, c가 D일 때, R에 따라서 첫번째 또는 마지막 값을 제거해준다.
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        dq.removeLast();
                    } else {
                        dq.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!dq.isEmpty()) {
                    sb.append(isReversed ? dq.removeLast() : dq.removeFirst());
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
