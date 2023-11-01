import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dfs(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void dfs(int r, int c, int size) {
        // 칠해진 색에 따라 white or blue 값 증가 시켜주기
        if (checkColor(r, c, size)) {
            if (board[r][c] == -1) {
                minus++;
            } else if (board[r][c] == 0) {
                zero++;
            } else {
                plus++;
            }
            return;
        }

        int newSize = size / 3;

        // 9개의 크기로 분리하여 재귀
        // 1, 4, 7
        dfs(r, c, newSize);
        dfs(r + newSize, c, newSize);
        dfs(r + 2 * newSize, c, newSize);

        // 2, 5, 8
        dfs(r, c + newSize, newSize);
        dfs(r + newSize, c + newSize, newSize);
        dfs(r + 2 * newSize, c + newSize, newSize);

        // 7 8 9
        dfs(r, c + 2 * newSize, newSize);
        dfs(r + newSize, c + 2 * newSize, newSize);
        dfs(r + 2 * newSize, c + 2 * newSize, newSize);
    }

    private static boolean checkColor(int r, int c, int size) {
        int color = board[r][c]; // 첫 원소의 색

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != color) { // 색이 다르면 false
                    return false;
                }
            }
        }
        return true;
    }
}

