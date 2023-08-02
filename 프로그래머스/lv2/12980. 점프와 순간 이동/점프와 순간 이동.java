import java.util.*;

public class Solution {
    public int solution(int n) {
        int k = 0;

        // n이 홀수, 짝수인 경우를 고려해서 홀수인 경우에만 k를 증가시킨다.
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                k++;
            }
        }

        return k;
    }
}