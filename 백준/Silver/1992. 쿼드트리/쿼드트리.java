import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /*
         * boj 1992 쿼드 정렬
         * 입력: 첫째 줄에는 영상의 크기를 나타내는 숫자 N 이 주어진다. N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64의 범위를 가진다. 두 번째 줄부터는 길이 N의 문자열이 N개 들어온다. 각 문자열은 0 또는 1의 숫자로 이루어져 있으며, 영상의 각 점들을 나타낸다.
         * 출력: 영상을 압축한 결과를 출력
         * 재귀적으로 4등분하여 압축된 결과를 출력하면 된다.
         * Divide And Conquer 문제의 전형!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        // 전체 체크 -> 4등분 후 체크
        dfs(0, 0, n);
        System.out.println(sb);
    }

    public static void dfs(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            sb.append(grid[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        dfs(x, y, newSize);
        dfs(x, y + newSize, newSize);
        dfs(x + newSize, y, newSize);
        dfs(x + newSize, y + newSize, newSize);

        sb.append(')');
    }

    // 모든 값이 같은지 확인하기
    public static boolean isPossible(int x, int y, int size) {
        int num = grid[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}