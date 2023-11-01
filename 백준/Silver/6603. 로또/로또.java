import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
          
            // 0이 입력으로 들어오면 종료
            if (n == 0) {
                break;
            }
            
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            temp = new int[6];
            visited = new boolean[n];
          
            combination(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
    
    static void combination(int start, int depth) {
        if (depth == 6) {
            for (int t : temp) {
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = start; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[depth] = arr[i];
                    combination(i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
