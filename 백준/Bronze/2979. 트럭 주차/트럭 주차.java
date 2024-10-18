import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 시간 별 주차된 차량의 수를 저장할 배열 선언
        int[] times = new int[101];
        int ans = 0;

        // 입력 받기, 끝 시간에는 나가는 시간이므로 제외해줘야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int min = 101;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                times[j]++;
            }
            min = Math.min(min, start);
            max = Math.max(max, end);
        }

        // 차량의 수 별로 요금을 계산
        for (int i = min; i < max; i++) {
            if (times[i] == 1) {
                ans += a;
            } else if (times[i] == 2) {
                ans += 2 * b;
            } else if (times[i] == 3){
                ans += 3 * c;
            }
        }

        System.out.println(ans);
    }
}