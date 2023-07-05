import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reported = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        
        // map 초기화, reported에는 신고한 사람의 수를 계산하기 위해서 HashSet 사용, idxMap에는 해당 위치에 있는 사용자의 인덱스를 저장
        for (int i = 0; i < id_list.length; i++) {
            reported.put(id_list[i], new HashSet<>());
            idxMap.put(id_list[i], i);
        }
        
        // 신고한 사람과 당한 사람을 reported에 저장
        for (String r : report) {
            String[] strArr = r.split(" ");
            reported.get(strArr[1]).add(strArr[0]);
        }
        
        // 하나씩 순회하면서 HashSet의 사이즈가 k 이상인지 확인
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> temp = reported.get(id_list[i]);
            if (temp.size() >= k) {
                for (String name : temp) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}