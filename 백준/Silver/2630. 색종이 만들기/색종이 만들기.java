import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int white = 0;
    static int blue = 0;
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

        seperation(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void seperation(int r, int c, int size) {
        // 칠해진 색에 따라 white or blue 값 증가 시켜주기
        if (checkColor(r, c, size)) {
            if (board[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 4개의 크기로 분리하여 재귀
        seperation(r, c, size / 2); // 2사분면
        seperation(r, c + size / 2, size / 2); // 1사분면
        seperation(r + size / 2, c, size / 2); // 3사분면
        seperation(r + size / 2, c + size / 2, size / 2); // 4사분면
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

