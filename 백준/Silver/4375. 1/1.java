import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 4375 1
        * 입력: n이 주어진다.(2 또는 5로 나누어 떨어지지 않음)
        * 출력: 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int cnt = 1;
            int ans = 1;
            while (true) {
                if (cnt % n == 0) {
                    sb.append(ans).append("\n");
                    break;
                } else {
                    cnt = (cnt * 10) + 1;
                    cnt %= n;
                    ans++;
                }
            }
        }
        System.out.println(sb);
    }
}