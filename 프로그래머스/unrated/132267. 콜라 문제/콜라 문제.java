class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (true) {
            // a가 n보다 커지는 순간에는 콜라를 더 받을 수가 없다.
            if (a > n) {
                break;
            }
            
            // 빈병의 개수를 구하고, 다음으로 생겨나는 빈병을 체크하기 위해 남은 병까지 더해서 n을 변경
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);
        }
        
        return answer;
    }
}