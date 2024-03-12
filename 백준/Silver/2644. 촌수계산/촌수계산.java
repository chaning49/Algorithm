import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] family;
    static boolean[] visited;
    static int ans = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 전체 사람의 수 n
        n = Integer.parseInt(br.readLine());
        
        // n x n 배열 생성
        family = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        // 촌수를 계산해야 하는 두 사람의 번호(target)
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        // 부모 자식들 간의 관계의 개수 m
        m = Integer.parseInt(br.readLine());
        
        // 부모 자식 간의 관계를 나타내는 번호 (x, y) -> m개, x가 y의 부모
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            family[p][s] = 1;
            family[s][p] = 1;
        }
        
        // bfs
        bfs(x, y);
        System.out.println(ans);
    }
    
    public static void bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int person = cur[0];
            int kinship = cur[1];
            
            if (person == end) {
                ans = kinship;
                return;
            }
            
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && family[person][i] == 1) {
                    visited[i] = true;
                    q.offer(new int[]{i, kinship + 1});
                }
            }
        }
    }
}