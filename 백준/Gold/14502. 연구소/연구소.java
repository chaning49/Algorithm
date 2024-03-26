import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    static int n, m;
    static int[][] grid;
    static int[][] virusArr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(ans);
    }
    
    public static void dfs(int depth) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    dfs(depth + 1);
                    grid[i][j] = 0;
                }
            }
        }
    }
    
    public static void spreadVirus() {
        Queue<int[]> q = new LinkedList<>();
        virusArr = new int[n][m];

        // 벽 3개인 grid로 똑같이 만들기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusArr[i][j] = grid[i][j];
                if (virusArr[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (virusArr[nx][ny] == 0) {
                    virusArr[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusArr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt);
    }
}