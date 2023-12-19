import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n;
    static List<Integer> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        /*
         * boj 2667 단지번호붙이기
         * 입력: 지도의 크기 n(5 이상 25 이하), n개의 자료(0 또는 1)
         * dfs로 정답을 구하는 문제이고, 기본 방식에서 응용이 들어간다.
         * 기본 문제는 연결된 부분의 개수만 구한다면 이 문제는 연결된 부분의 크기까지 저장해서 보여줘야 한다는 것이다.
         * 출력: 첫째줄에는 총 단지수 출력, 이후 단지 내 집의 수를 오름차순으로 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, grid 초기화
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] rows = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(rows[j]);
            }
        }

        // grid를 순회하면서 단지 개수, 크기를 저장한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ansList.add(dfs(i, j));
                }
            }
        }

        // 오름차순 정렬 후 출력
        Collections.sort(ansList);
        System.out.println(ansList.size());
        for (int ans : ansList) {
            System.out.println(ans);
        }
    }
    
    // dfs
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                size += dfs(nx, ny);
            }
        }
        return size;
    }
}