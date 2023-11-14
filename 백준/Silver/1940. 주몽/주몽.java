import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 1213 팰린드롬 만들기
        * 입력: 재료의 개수 n, 갑옷을 만드는 데 필요한 수 m, n개의 재료들
        * 출력: 만들 수 있는 갑옷의 개수
        * n이 최대 15,000이기 때문에 O(N^2)은 불가
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] meterials = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            meterials[i] = Integer.parseInt(inputs[i]);
        }

        // 두 개의 재료가 m이 되는지
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (meterials[i] + meterials[j] == m) ans++;
            }
        }

        System.out.println(ans);
    }
}