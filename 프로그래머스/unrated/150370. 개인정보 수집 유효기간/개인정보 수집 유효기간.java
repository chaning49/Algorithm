import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();
        int day = makeDate(today);
        
        // terms를 저장할 Map
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termsMap.put(t[0], Integer.parseInt(t[1]));
        }
        
        // pivacies에 있는 날짜들과 유효기간 만큼을 합한 값을 today와 비교해서 인덱스를 찾는다.
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (makeDate(privacy[0]) + (termsMap.get(privacy[1]) * 28) <= day) {
                ansList.add(i + 1);
            }  
        }
        
        // 정답 배열에 넣어주기
        answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
    
    // 현재 날짜를 숫자로 환산하는 메서드
    private int makeDate(String day) {
        String[] date = day.split("\\.");
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);
        
        return (y * 12 * 28) + (m * 28) + d;
    }
}