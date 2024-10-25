import java.io.*;
import java.util.*;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        // 재귀함수 돌리기
        System.out.println(go(a, b));
    }


    // 분할 정복 Algorithm
    public static long go(long a, long b) {
        // 기저사례, 지수가 1이 되는 경우
        if (b == 1) return a % c;

        // 재귀 호출로 절반 계산
        long ret = go(a, b / 2);

        // 계산된 값을 제곱하여 모듈러 연산
        ret = (ret * ret) % c;

        // 지수가 홀수인 경우 a를 추가로 곱해주어야 한다.
        if (b % 2 == 1) ret = (ret * a) % c;

        return ret;
    }
}