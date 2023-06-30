class Solution {
    public int solution(int n) {
        // 누적합을 더할 dp
        int[] dp = new int[n];
        
        // 피보나치의 첫번째, 두번째 값 저장
        dp[0] = 1;
        dp[1] = 2;
        
        // n까지 피보나치 구하기
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        
        return dp[n - 1];
    }
}