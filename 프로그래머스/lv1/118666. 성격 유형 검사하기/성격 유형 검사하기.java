import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 지표와 점수를 저장할 map과 인덱스에 해당하는 점수 scores 선언
        Map<String, Integer> indicator = new HashMap<>();
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        
        // survey[i]를 나누고 choices[i]를 따로 저장한 후 str에 choice 값에 따라 알파벳 저장 후 점수 증가
        for (int i = 0; i < survey.length; i++) {
            String[] response = survey[i].split("");
            int choice = choices[i];
            String str = choice < 4 ? response[0] : response[1];
            indicator.put(str, indicator.getOrDefault(str, 0) + scores[choice]);
        }
        
        // 0인 경우에는 알파벳 순서이므로 하나씩 이어붙여줌
        StringBuilder sb = new StringBuilder()
            .append(indicator.getOrDefault("R", 0) >= indicator.getOrDefault("T", 0) ? "R" : "T")
            .append(indicator.getOrDefault("C", 0) >= indicator.getOrDefault("F", 0) ? "C" : "F")
            .append(indicator.getOrDefault("J", 0) >= indicator.getOrDefault("M", 0) ? "J" : "M")
            .append(indicator.getOrDefault("A", 0) >= indicator.getOrDefault("N", 0) ? "A" : "N");
        
        return sb.toString();
    }
}