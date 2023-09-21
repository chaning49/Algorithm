class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // n을 k진수로 변경
        String parseNum = Integer.toString(n, k);
        
        // 바뀐 수를 0을 기준으로 자르기
        for (String str : parseNum.split("0")) {
            if (str.length() > 0 && isPrime(Long.parseLong(str, 10))) {
                answer++;
            }
        }    
        
        return answer;
    }
    
    // 소수 판별
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}