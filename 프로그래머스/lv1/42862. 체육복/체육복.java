import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 전체 학생 수에서 도난당한 학생의 수를 뺀 값을 우선 저장
        int answer = n - lost.length;
        
        // 도난당한 학생과 여벌을 가져온 학생들을 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer += 1;
                    lost[i] = -1000;
                    reserve[j] = -1000;
                    break;
                }
            }
        }

        // lost의 값을 하나씩 꺼내와서 reserve에 있는 값과 비교 했을 때, 차이가 1인지 확인
        for (int l : lost) {
            for (int j = 0; j < reserve.length; j++) {
                int temp = l - reserve[j];
                if (Math.abs(temp) == 1) {
                    answer += 1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}