import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ret, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        /*
        * boj 2636 치즈
        * 입력: 첫째 줄에는 가로, 세로(1 <= 가로, 세로 <= 100), 그 다음 줄부터 모양이 주어지고 치즈가 없으면 0, 있으면 1
        * 출력: 첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간 출력, 둘째 줄에는 모두 녹기 한 시간 저에 남아있는 치즈 조각이 놓인 개수 출력
        * 좌표별로 네 방향에 0이 존재하면 해당 좌표까지 0으로 변경하여 녹는 과정을 보여줄 수 있다.
        * 또한 남은 치즈의 개수가 0이 되기 전까지의 개수를 기록하면 된다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false); // 방문 상태 초기화
            }
            list = new ArrayList<>();
            dfs(0, 0);
            cnt = list.size(); // 개수는 리스트의 크기
            for (int[] l : list) {
                grid[l[0]][l[1]] = 0; // 리스트에 있는 원소들이 녹은 치즈이다.
            }
            boolean check = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 0) check = true; // 하나라도 1인 경우, 아직 치즈가 남아 있다는 의미
                }
            }
            ret++; // 횟수 증가
            if (!check) break;
        }

        System.out.println(ret + "\n" + cnt);
    }

    // dfs
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        if (grid[y][x] == 1) { // 처음으로 1이 등장하면 멈춘다.
            list.add(new int[] {y, x}); // 녹을 치즈 좌표 저장
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }
}