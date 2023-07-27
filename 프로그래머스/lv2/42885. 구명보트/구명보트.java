import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 맨 앞과 맨 뒤 인덱스 설정
        int start = 0;
        int end = people.length - 1;
        
        // 배열 오름차순 정렬
        Arrays.sort(people);
        
        // start와 end의 인덱스에 해당하는 값의 합이 limit 이하인 경우와 그렇지 않은 경우를 처리해서 구명보트의 개수를 구할 수 있다.
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}