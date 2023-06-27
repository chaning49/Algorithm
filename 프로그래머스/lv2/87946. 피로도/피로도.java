class Solution {
    private static int answer = 0;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // 가능한 모든 경우를 탐색 => 완전 탐색
        dfs(0, k, dungeons);
        return answer;
    }
    
    private void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 던전이고 던전의 최소 필요 피로도가 k보다 작거나 같은 경우에 조건문 실행
            // i에 해당하는 던전 방문처리 후 dfs에서 depth 진행 후 k에서 소모 피로도를 뺀 dfs로 한 차례 재귀 실행
            // dfs의 한 사이클 종료시 방문했던 던전을 다시 방문하지 않은 상태(false)로 만든다.
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        // dfs를 반복할 때마다 가능한 최대 방문 수를 정답에 저장
        answer = Math.max(answer, depth);
    }
}