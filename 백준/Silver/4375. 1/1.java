import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        // 모듈러 연산의 특징을 이해하여야 한다.
        // (a + b) % c = ((a % c) + (b % c)) % c
        // (a * b) % c = ((a % c) * (b % c)) % c

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            n = Integer.parseInt(input);

            // 1, 11, 111, ... 을 만들 cnt와 자리수를 저장할 ret 선언
            long cnt = 1;
            long ret = 1;

            while (true) {
                if (cnt % n == 0) { // 1, 11, 111, ...  중에서 n으로 나누어 떨어지는, 즉 배수인 경우 stop
                    System.out.println(ret);
                    break;
                } else {
                    cnt = (cnt * 10) + 1; // 1, 11, 111을 만들기 위한 연산
                    cnt %= n; // long의 범위를 벗어나는 경우를 고려하여 곱셈마다 모듈러 연산
                    ret++;
                }
            }
        }
    }
}