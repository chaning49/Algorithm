import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int nextCode = 27; // 다음 인덱스 번호
        
        // A부터 Z까지 알파벳 저장
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), c - 'A' + 1);
        }
        
        // 현재 문자열
        String current = "";
        
        for (char c : msg.toCharArray()) {
            // 현재 문자열 + 다음 문자열
            String combined = current + c;
            
            // 사전에 존재하면 현재 문자열로 변경
            if (dictionary.containsKey(combined)) {
                current = combined;
            } else {  // 사전에 존재하지 않으면
                result.add(dictionary.get(current)); // 현재까지 생성된 문자열의 index 저장
                dictionary.put(combined, nextCode++); // 사전에 새로 저장
                current = String.valueOf(c); // 다음 문자열을 현재 문자열로 변경
            }
        }
        
        // 마지막에 처리되지 않은 문자열의 index를 저장
        result.add(dictionary.get(current));
        
        // List를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
