import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 11723 집합
         * 입력: 수행해야 하는 연산의 수 M(최대 300만), 연산 M개
         * 출력: check 연산이 주어지면 결과 출력
         * 해당 문제는 비트마스킹을 사용하여 풀 수 있는 문제이다.
         * 단순한 연산은 시간과 메모리 초과를 일으키기 때문이다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0;
        // m 입력 받기
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        // m회 연산 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = -1;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (order) {
                case "add":
                    S |= (1 << x);
                    break;
                case "remove":
                    S &= ~(1 << x);
                    break;
                case "check":
                    sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << x);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}