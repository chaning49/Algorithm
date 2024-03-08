import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // n x n 배열 생성
        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // grid 간선 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        // dfs 탐색
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }


    // dfs
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        if (start == grid.length) return;
        for (int i = 1; i <= n; i++) {
            if (grid[start][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    // bfs
    public static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");
            for (int i = 1; i <= n; i++) {
                if (grid[start][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}