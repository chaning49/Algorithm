import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0 ,0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // bfs를 사용할 것이기 때문에 큐 선언, 내부 값은 int[] 타입으로 x와 y 좌표를 저장해주기 위함이다.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // 출발지
        
        while (!q.isEmpty()) {
            int[] dir = q.poll();
            
            // 좌우상하만큼만 움직이면서 더 나아갈 수 없으면 continue 나아갈 수 있다면 이전 방문지에 1씩 증가 후 큐에 삽입
            for (int i = 0; i < 4; i++) {
                int x = dir[0] + dx[i];
                int y = dir[1] + dy[i];
                
                if (x < 0 || y < 0 || x >= n || y >= m || maps[x][y] == 0) {
                    continue;
                } 
                
                if (maps[x][y] == 1) {
                    maps[x][y] = maps[dir[0]][dir[1]] + 1;
                    q.offer(new int[]{x, y});
                }
                
            }
        }
        
        // 큐를 한번 순회했을 때, 마지막 위치의 원소가 1이 아니면 최단 경로가 존재하는 것이고, 아니면 없는 것이다.
        return maps[n - 1][m - 1] != 1 ? maps[n - 1][m - 1] : -1;
    }
}