import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n과 m 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        // n x m 사이즈의 2차원 배열 생성, 방문 표시용 2차원 배열 생성
        map = new int[n][m];
        isVisited = new boolean[n][m];

        // 2차원 배열 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 최대 공간의 크기와 개수를 저장할 변수 선언
        int maxArea = 0;
        int cnt = 0;

        // dfs를 사용하여 1이면서 방문하지 않은 배열을 파고든다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    cnt++;
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);

        sc.close();
    }

    static int dfs(int x, int y) {
        isVisited[x][y] = true;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (!isVisited[nx][ny] && map[nx][ny] == 1) {
                area += dfs(nx, ny);
            }
        }

        return area;
    }
}