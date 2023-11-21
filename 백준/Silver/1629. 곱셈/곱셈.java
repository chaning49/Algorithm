import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        /*
        * boj 1629 곱셈
        * 입력: a, b, c는 최대 21억
        * 출력: a를 b번 곱한 값을 c로 나눈 나머지
        * 범위 때문에 a를 b번 곱하는 경우, overflow가 발생하므로 각 연산마다 c로 모듈러 연산을 해주는 동시에 재귀적 호출을 통해 O(logN)의 시간을 갖도록 한다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(go(a, b));
    }

    private static long go(long a, long b) {
        // 지수가 1인 경우
        if (b == 1) {
            return a % c;
        }
        long temp = go(a, b / 2);
        temp = (temp * temp) % c;
        if (b % 2 == 1) { // 지수가 홀수인 경우
            temp = (temp * a) % c;
        }
        return temp;
    }
}