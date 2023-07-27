class Solution {
    public int solution(int a, int b) {
        // 최대공약수로 기약분수의 분모 구하기
        int answer = b / gcd(a, b);
        
        // 분모가 2와 5로 나누었을 때, 1이 될 때까지 나눠준다. 만약 2와 5로 나누지 못하는 분모가 나오면 2를 반환해준다.
        while (answer != 1) {
            if (answer % 2 == 0) {
                answer /= 2;
            } else if (answer % 5 == 0) {
                answer /= 5;
            } else {
                return 2;
            }
        }
        
        return answer;
    }
    
    // 최대공약수를 구하는 알고리즘
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } 
        return gcd(b, a % b);
    }
}