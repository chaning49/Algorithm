import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 약수별로 limit와 값 비교 후 power 또는 약수 개수를 더한다.
        for (int i = 1; i <= number; i++) {
            int n = findDivisor(i);
            if (n > limit) {
                answer += power;
            } else {
                answer += n;
            }
        }
        
        return answer;
    }
    
    // 약수를 구하는 메서드
    private int findDivisor(int number) {
        int cnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                cnt++;
            } else if (number % i == 0) {
                cnt += 2;
            }
        }
        
        return cnt;
    }
}