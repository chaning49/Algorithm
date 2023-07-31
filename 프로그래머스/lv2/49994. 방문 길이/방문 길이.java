import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String dirs) {
        int answer = 0;
        // 좌표평면
        int[][] board = new int[11][11];
        
        // 방향 표시용 3차원 배열
        boolean[][][] isVisited = new boolean[11][11][4];
        
        // 초기화
        for (int i = 0; i < 11; i++) {
            Arrays.fill(board[i], 0);
        }
        int x = 5;
        int y = 5;
        
        // 방향에 따라 x, y 좌표 이동
        for (char d : dirs.toCharArray()) {
            int dir = 0;
            if (d == 'U') {
                dir = 0;
            } 
            if (d == 'L') {
                dir = 1;
            } 
            if (d == 'D') {
                dir = 2;
            } 
            if (d == 'R') {
                dir = 3;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                continue;
            }
            
            // dir의 역방향도 방문 표시를 해줘야한다.
            if (!isVisited[nx][ny][dir]) {
                isVisited[nx][ny][dir] = true;
                dir = (dir % 2 == 0) ? 2 - dir : 4 - dir;
                isVisited[x][y][dir] = true;
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}