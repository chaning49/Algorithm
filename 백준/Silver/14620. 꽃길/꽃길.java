import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] ground;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 3004;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ground = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ret);
    }

    // dfs
    public static void dfs(int depth, int sm) {
        if (depth == 3) {
            ret = Math.min(ret, sm);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkGround(i, j)) {
                    dfs(depth + 1, sm + setFlower(i, j));
                    removeFlower(i, j);
                }
            }
        }
    }

    // 심을 수 있는 위치인지 확인하기
    public static boolean checkGround(int y, int x) {
        if (visited[y][x]) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) {
                return false;
            }
        }
        return true;
    }

    // 꽃 심기
    public static int setFlower(int y, int x) {
        visited[y][x] = true;
        int sm = ground[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = true;
            sm += ground[ny][nx];
        }
        return sm;
    }

    // 해제
    public static void removeFlower(int y, int x) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = false;
        }
    }
}