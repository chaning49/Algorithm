import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1부터 n까지 값을 LinkedList에 저장
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        // dq에 값이 하나만 남을 때까지 반복
        while (dq.size() > 1) {
            // 맨 앞에 위치한 값을 버린다.
            dq.pollFirst();

            // 그 다음으로 맨 앞에 있는 수를 맨 뒤로 보낸다.
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.peek());
    }
}
