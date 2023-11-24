class Solution {
    public long solution(int n) {
        // 규칙: a[i] = a[i - 2] + a[i - 1];
        // 피보나치 저장용 배열 선언
        long[] fibo = new long[n + 4];
        fibo[1] = 1l;
        fibo[2] = 2l;
        fibo[3] = 3l;
        
        // 값을 구할때마다 모듈러 연산
        for (int i = 4; i <= n; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        }
        
        return fibo[n];
    }
}