import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] linkedCom;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        /*
         * boj 1932 정수 삼각형
         * 입력: 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
         * 출력: 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력
         * 결과가 2개인 경우, 둘 중에서 큰 값만 반영하도록 만들기? -> 양 끝을 제외한 나머지 인덱스는 결과가 2개씩 나온다.
         * tri의 첫번째 열에 위치한 값(tri[i][0]은 비교할 필요가 없으므로 처음부터 누적한 값을 더한다.
         * 나머지 위치에 있는 값들은 dp[i - 1][j - 1]과 dp[i - 1][j] 중 큰 값을 더해줄 수 있도록 한다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터의 개수 n
        n = Integer.parseInt(br.readLine());
        linkedCom = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 연결된 컴퓨터의 개수 m
        int m = Integer.parseInt(br.readLine());

        // m개의 컴퓨터 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            linkedCom[c1][c2] = 1;
            linkedCom[c2][c1] = 1;
        }

        // bfs
        bfs(1);
        System.out.println(ans);
    }

    // 1번 컴퓨터를 기준으로 연결된 모든 컴퓨터의 개수 출력
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && linkedCom[cur][i] == 1) {
                    q.offer(i);
                    ans++;
                    visited[i] = true;
                }
            }
        }
    }
}