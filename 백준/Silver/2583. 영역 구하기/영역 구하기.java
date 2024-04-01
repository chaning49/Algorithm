import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int num = 0;
    static int size;

    public static void main(String[] args) throws IOException {
        /*
         * boj 2583 영역 구하기
         * 입력: 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
         * 출력: 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력
         * 입력받은 좌표에 맞춰서 사각형이 존재하는 좌표에 표시한다.
         * 개수와 크기를 구해야 하므로 dfs를 순회하면서 영역의 개수와 넓이를 저장한 후 출력한다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        paper = new int[m][n];
        visited = new boolean[m][n];

        // 좌표를 입력받고, 입력받은 좌표 사이에 위치한 값을 1로 변경
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            makeRectangle(x1, y1, x2, y2);
        }

        List<Integer> list = new ArrayList<>();
        // dfs 순회하면서 개수와 크기를 구한다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                size = 0;
                if (!visited[i][j] && paper[i][j] == 0) {
                    dfs(i, j);
                    num++;
                    list.add(size);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("\n");
        for (int l : list) {
            sb.append(l).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (!visited[ny][nx] && paper[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
        size++;
    }

    public static void makeRectangle(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                paper[j][i] = 1;
            }
        }
    }
}