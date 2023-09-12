import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] players = new int[N + 2];
        double[] fail = new double[N + 1];
        
        // 총 플레이어 수 저장
        int totalPlayers = stages.length;
        
        // 현재 플레이어들의 스테이지별 인원 수
        for (int stage : stages) {
            players[stage]++;
        }
        
        // 스테이지별 플레이어의 실패율 체크(인원 수를 줄여가면서 확인)
        for (int i = 1; i <= N; i++) {
            if (players[i] != 0) {
                fail[i] = (double) players[i] / totalPlayers;
                totalPlayers -= players[i];
            } else {
                fail[i] = 0.0;
            }
        }
        
        // 정답에 해당하는 실패율을 음수로 만들면서 내림차순으로 정렬
        for (int i = 0; i < N; i++) {
            double max = -1;
            for (int j = 1; j <= N; j++) {
                if (fail[j] > max) {
                    max = fail[j];
                    answer[i] = j;
                }
            }
            fail[answer[i]] = -1;
        }

        return answer;
    }
}