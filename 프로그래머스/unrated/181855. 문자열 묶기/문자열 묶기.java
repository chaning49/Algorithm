import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        // 1부터 30까지의 문자열의 길이 개수를 저장하기 위한 배열
        int[] lengthOfStr = new int[31];
        
        // strArr에 있는 문자열의 길이에 해당하는 배열 값을 증가
        for (String str : strArr) {
            lengthOfStr[str.length()]++;
        }
        
        // 오름차순으로 정렬
        Arrays.sort(lengthOfStr);
        
        // 마지막에 위치한 값이 최대
        answer = lengthOfStr[30];
        
        return answer;
    }
}