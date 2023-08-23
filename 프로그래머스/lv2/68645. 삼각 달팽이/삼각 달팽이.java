class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int maxNum = (n * (n + 1)) / 2;
        
        int num = 1;
        int x = -1;
        int y = 0;
        
        while (num <= maxNum) {
            // 대각선 아래 방향
            for (int i = 0; i < n; i++) {
                x++;
                triangle[x][y] = num++;
            }
            
            // 왼쪽에서 오른쪽
            for (int i = 0; i < n - 1; i++) {
                y++;
                triangle[x][y] = num++;
            }
            
            // 대각선 위 방향
            for (int i = 0; i < n - 2; i++) {
                x--;
                y--;
                triangle[x][y] = num++;
            }
            
            // 삼각형 크기 줄여주기
            n -= 3;
        }
        
        int[] answer = new int[maxNum];
        int idx = 0;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}