import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxHeight = 0;
    static int safeArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        // 입력받으면서 높이의 최댓값을 찾는다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        // 높이의 최댓값까지 1씩 증가시키면서 안전 영역의 최댓값 구하기
        int height = 0;
        while (height < maxHeight) {
            setSafeArea(height);
            int curSafeArea = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > height && !visited[i][j]) {
                        dfs(height, i, j);
                        curSafeArea++;
                    }
                }
            }
            safeArea = Math.max(safeArea, curSafeArea);
            height++;
        }

        System.out.println(safeArea);
    }

    public static void dfs(int height, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (grid[nx][ny] > height && !visited[nx][ny]) {
                dfs(height, nx, ny);
            }
        }
    }
    
    // 안전 영역이 아닌 곳을 미리 방문 표시하여 dfs에서 방문하지 않도록 한다.
    public static void setSafeArea(int height) {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }
    }
}