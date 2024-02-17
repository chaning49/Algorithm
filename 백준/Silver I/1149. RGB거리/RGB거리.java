import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 1149 RGB 거리
         * 입력: 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
         * 출력: 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력
         * i번째 집마다 이전 집의 최소 가격을 합하여 나온 최종 견적을 구하면 된다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 0: Red, 1: Green, 2: Blue
        int[][] price = new int[n][3];

        // 집마다 다른 RGB 가격 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        // 2번째 집부터 색상 별 최솟값을 누적해서 구한다.
        for (int i = 1; i < n; i++) {
            price[i][0] += Math.min(price[i - 1][1], price[i - 1][2]);
            price[i][1] += Math.min(price[i - 1][0], price[i - 1][2]);
            price[i][2] += Math.min(price[i - 1][0], price[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(price[n - 1][0], price[n - 1][1]), price[n - 1][2]));
    }
}