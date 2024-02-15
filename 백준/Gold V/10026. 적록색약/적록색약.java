import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        /*
         * boj 10026 적록색약
         * 입력: 수의 개수 N, NxN 크기의 그림
         * 출력: 적록색약이 아닌 사람이 보는 구역의 수, 적록색약인 사람이 보는 구역의 수
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int normal = 0;
        int colorBlind = 0;

        // 적록색약이 아닌 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    normal++;
                }
            }
        }

        visited = new boolean[n][n];

        // 적록색약인 사람을 구하기 위해 G -> R로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }

        // 적록색약인 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    colorBlind++;
                }
            }
        }

        System.out.println(normal + " " + colorBlind);
    }

    public static void dfs (int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && grid[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}