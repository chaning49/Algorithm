class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] checkBoard = new boolean[n][n];
            
        // 지뢰를 찾아서 위험지역을 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    checkDanger(checkBoard, i, j, n);
                }
            }
        }
        
        // false인 곳이 안전지대
        for (boolean[] checkRow : checkBoard) {
            for (boolean isDanger : checkRow) {
                if (!isDanger)
                    answer++;
            }
        }
        
        return answer;
    }
    
    // 8방향 + 해당 좌표를 기준으로 값을 바꿔줄 수 있는지 확인하는 메소드
    private void checkDanger(boolean[][] board, int i, int j, int n) {
        int[] dx = {0, -1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {0, -1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int idx = 0; idx < 9; idx++) {
            int x = i + dx[idx];
            int y = j + dy[idx];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                board[x][y] = true;
            }
        }
    }
    
}
