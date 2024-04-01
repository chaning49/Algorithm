import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
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