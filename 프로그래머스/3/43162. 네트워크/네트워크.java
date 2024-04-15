class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        // dfs 순회하기
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < visited.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                System.out.println("x: " + i + " y: " + j);
                dfs(j, visited, computers);
            }
        }
    }
}