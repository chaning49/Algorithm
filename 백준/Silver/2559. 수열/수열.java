import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 k를 저장하고, 크기가 n인 배열 생성
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 구간합을 저장할 배열
        // 입력된 배열의 크기가 n일 때, n + 1 크기의 구간합 배열을 선언하여 구간합을 저장해준다.
        int[] psum = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        // 구간합 구하기
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // k개의 값의 합 중에서 최대인 것만 저장하기
        int max = -10000009;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, psum[i] - psum[i - k]);
        }

        System.out.println(max);
    }
}