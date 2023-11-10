import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 2559 수열
        * n일 중에서 연속되는 k일 간의 온도 합의 최대값을 구하자
        * 입력: n, k, n개의 온도값
        * 출력: 최대값
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        String[] t = br.readLine().split(" ");

        // 크기가 n인 int 배열 생성
        int[] temp = new int[n];

        // 배열에 값 초기화
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(t[i]);
        }

        // k 값에 따라 첫날부터 k번째 날짜 만큼 sliding window
        // 초기 k개의 값의 합 저장
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += temp[i];
        }
        
        // 초기 k개의 값의 합 중에서 최대인 것만 저장
        int num = max;
        for (int i = 0; i < n - k; i++) {
            num += temp[i + k] - temp[i];
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}