import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    // 최단거리이므로 bfs
    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            x = curr[0];
            y = curr[1];

            if (x == n - 1 && y == m - 1) {
                return board[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    board[nx][ny] = board[x][y] + 1;
                }
            }
        }

        return -1; // 여기는 올 일이 없어야 함
    }
}

