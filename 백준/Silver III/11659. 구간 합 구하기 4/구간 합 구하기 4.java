import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 11659 구간 합 구하기 4
         * 입력: 수의 개수 N, 합을 구해야 하는 수 M, M개의 줄에는 합을 구해야 하는 i와 j가 주어짐
         * 출력: 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력
         * 구간 합을 구하는 문제
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m 저장
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1부터 n까지의 합이 순차적으로 저장될 배열 선언
        int[] sum = new int[n + 1];

        // 숫자 n개를 순차적으로 합하기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // m번 반복하며 구간합을 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // 입력된 i 이전까지의 합을 j까지의 합에서 빼주면 구간합을 구할 수 있다.
            sb.append(sum[end] - sum[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}