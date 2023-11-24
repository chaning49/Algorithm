class Solution {
    public long solution(int n) {
        // 규칙: a[i] = a[i - 2] + a[i - 1];
        long answer = 0;
        
        // 피보나치 저장용 배열 선언
        int[] fibo = new int[n + 4];
        fibo[1] = 1;
        fibo[2] = 2;
        fibo[3] = 3;
        
        // 값을 구할때마다 모듈러 연산
        for (int i = 4; i <= n; i++) {
            fibo[i] = ((fibo[i - 2] % 1234567) + (fibo[i - 1] % 1234567)) % 1234567;
        }
        
        answer = fibo[n] % 1234567;
        
        return answer;
    }
}