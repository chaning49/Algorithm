import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 9095 1, 2, 3 더하기
         * 입력: 테스트케이스 T, 테스트케이스 수 만큼의 입력
         * 출력: 테스트케이스마다 정답 출력
         * 이전 3회의 연산이 찾는 값에 영향을 주고 있으므로 dp이다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // n은 11 미만이므로 11 크기의 dp 배열 생성 후 1, 2, 3번째 값 초기화
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 이전 3개의 개수를 모두 더하면 현재 방법의 수가 나온다.
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}