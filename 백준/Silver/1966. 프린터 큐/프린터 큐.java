import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 1966 프린터 큐
         * 중요도에 따라 원하는 문서가 몇 번째로 출력되는지 확인하는 문제
         * 입력: t(테스트케이스), n(문서의 개수), m(궁금한 문서가 현재 큐에서 몇 번째에 놓여있는지 나타내는 정수, 맨 왼쪽은 0)
         * 출력: n개의 문서의 중요도가 차례대로 주어진다.(중요도는 1~9 사이, 중요도가 같은 문서가 여러 개 있을 수 있다.)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // n, m 입력
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 문서의 중요도 입력 - 큐
            // 최댓값 찾기
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            // 출력 횟수
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                boolean isHigh = false;

                for (int[] arr : q) {
                    if (arr[1] > cur[1]) {
                        isHigh = true;
                        break;
                    }
                }

                if (isHigh) {
                    q.offer(cur);
                } else {
                    cnt++;
                    if (cur[0] == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}