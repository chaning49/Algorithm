import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();
        
        // 기간을 저장할 배열
        int[] period = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            period[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                period[i]++;
        }
        
        // 기간별로 최대 몇 개의 기능을 배포할 수 있는지 확인하면서 ansList에 저장
        int cnt = 1;
        int chk = period[0];
        for (int i = 1; i < period.length; i++) {
            if (chk >= period[i])
                cnt++;
            else {
                ansList.add(cnt);
                cnt = 1;
                chk = period[i];
            }
        }
        // 마지막 개수를 추가해준다.
        ansList.add(cnt);
        
        // 배열로 만들기
        answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++)
            answer[i] = ansList.get(i);
        
        return answer;
    }
}