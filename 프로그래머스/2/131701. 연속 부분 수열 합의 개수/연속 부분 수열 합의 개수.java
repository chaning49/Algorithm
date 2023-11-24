import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 중복이 없어야 하기 때문에 Set을 사용한다.
        Set<Integer> set = new HashSet<>();
        
        // 연속 부분 수열의 길이
        int len = 1;
        
        // 연속 부분 수열의 길이가 elements의 길이까지만 순회한다.
        while (len <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int temp = 0;
                for (int j = i; j < i + len; j++) {
                    temp += elements[j % elements.length]; // 원형 수열을 찾아주려면 수열의 길이를 기준으로 모듈러 연산을 통해 다음 인덱스를 찾을 수 있다.
                }
                set.add(temp);
            }
            len++;
        }
        
        return set.size();
    }
}