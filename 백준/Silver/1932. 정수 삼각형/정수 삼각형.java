import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 1932 정수 삼각형
         * 입력: 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
         * 출력: 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력
         * 결과가 2개인 경우, 둘 중에서 큰 값만 반영하도록 만들기? -> 양 끝을 제외한 나머지 인덱스는 결과가 2개씩 나온다.
         * tri의 첫번째 열에 위치한 값(tri[i][0]은 비교할 필요가 없으므로 처음부터 누적한 값을 더한다.
         * 나머지 위치에 있는 값들은 dp[i - 1][j - 1]과 dp[i - 1][j] 중 큰 값을 더해줄 수 있도록 한다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 삼각형과 같은 크기의 dp 선언
        int[][] tri = new int[n][n];
        int[][] dp = new int[n][n];

        // 삼각형을 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 왼쪽에 위치한 값들은 미리 값을 저장한다.
        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + tri[i][0];
        }

        // 나머지는 i - 1, j - 1과 i - 1, j - 1에 해당하는 값 중 최대값에 tri[i][j]를 더한다.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
            }
        }

        // 정답 구하기
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }

        System.out.println(ans);
    }
}