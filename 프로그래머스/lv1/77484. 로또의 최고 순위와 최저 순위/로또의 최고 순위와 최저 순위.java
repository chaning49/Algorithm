import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 결과 값을 담을 배열
        int[] answer = new int[2];
        // 로또 순위를 나타내는 배열, 인덱스는 맞춘 번호의 개수
        int[] sequence = {6, 6, 5, 4, 3, 2, 1};
        
        // 당첨 번호를 HashSet에 저장, 검색 시간 복잡도를 O(1)로 개선
        Set<Integer> winNums = new HashSet<>();
        for (int w : win_nums) {
            winNums.add(w);
        }
        
        // 맞춘 번호의 개수(n)와 알 수 없는 번호의 개수(k)를 초기화
        int n = 0;
        int k = 0;
        
        // lottos 배열을 순회하며 맞춘 번호와 알 수 없는 번호를 센다
        for (int l : lottos) {
            if (l == 0) { // 알 수 없는 번호인 경우
                k++;
                continue;
            }
            // 당첨 번호인 경우
            if (winNums.contains(l)) {
                n++;
            }
        }
        
        // 최고 순위와 최저 순위를 계산해 배열에 저장
        answer[0] = sequence[n + k]; // 최고 순위는 맞춘 번호와 알 수 없는 번호를 모두 합한 것
        answer[1] = sequence[n]; // 최저 순위는 맞춘 번호만을 기준으로 한다
        
        return answer; // 결과를 반환
    }
}
