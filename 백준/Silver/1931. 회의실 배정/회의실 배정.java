import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        /*
         * boj 1931 회의실 배정
         * 입력: 첫째 줄에는 회의의 수 N(1~10만), 둘째 줄부터는 각 회의의 정보(시작 시간과 끝나는 시간은 2^31 - 1보다 작거나 같은 자연수 또는 0)
         * 출력: 최대 사용할 수 있는 회의의 최대 개수를 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 오름차순 정렬 + 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        // arr의 첫 번째 값의 끝나는 시간을 초기 값으로 넣고, 시작 시간과 fin을 비교하면서 시작시간이 fin 이상이면 횟수 증가 후 fin 변경
        int fin = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= fin) {
                cnt++;
                fin = arr[i][1];
            }
        }
        System.out.println(cnt);
    }
}