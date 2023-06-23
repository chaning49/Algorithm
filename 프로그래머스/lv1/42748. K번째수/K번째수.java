import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        
        // commands의 전체 길이만큼 순회
        for (int i = 0; i < commands.length; i++) {
            // 각 commands의 자릿수에 따라 값을 저장
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]); 
            }
            // 오름차순 정렬 후 commands[i][2]에 위치한 인덱스에 따라 값 저장
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
            list.clear();
        }
        
        return answer;
    }
}