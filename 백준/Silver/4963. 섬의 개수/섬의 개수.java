import java.util.*;
import java.io.*;

class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int w, h;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // l, lu, u, ru, r, rd, d, ld
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 종료
            if (w == 0 && h == 0) {
                break;
            }

            // w x h 크기 배열 만들기
            grid = new int[h][w];
            visited = new boolean[h][w];

            // 배열 초기화
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dfs
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            
            System.out.println(ans);
        }
    }
    
    // dfs
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (!visited[nx][ny] && grid[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}