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
        int[] arr = new int[n];

        // 수열 입력받기
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < k) sum += arr[i]; // 배열에서 k개의 합을 우선 구하기
        }

        // 미리 더한 값에서 한 칸씩 이동하면서 최대값을 찾기
        int max = sum;
        for (int i = 0; i < n - k; i++) {
            sum = sum - arr[i] + arr[i + k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}