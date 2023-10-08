import java.util.*;

class Solution {
    static String[] vowel;
    static List<String> words;
    static boolean isFinished;
    
    public int solution(String word) {
        // 정적 변수 초기화
        vowel = new String[]{"A", "E", "I", "O", "U"};
        words = new ArrayList<>();
        isFinished = false;
        
        recursion(word, "");
        
        return words.indexOf(word);
    }
    
    // 재귀를 돌면서 단어를 하나씩 저장
    static void recursion(String word, String str) {
        // 정답을 찾으면 words에 더이상 추가하지 않음
        if (isFinished) {
            return;
        }
        
        // str을 words에 추가
        words.add(str);
        
        // 정답과 같으면 더이상 add하지 않도록 boolean 값 변경
        if (word.equals(str)) {
            isFinished = true;
            return;
        }
        
        // 길이가 5인 경우 추가한 이후 멈추기
        if (str.length() == 5) {
            return;
        }
        
        // 추가할 수 있는 모음을 순차적으로 붙여서 재귀
        for (int i = 0; i < vowel.length; i++) {
            recursion(word, str + vowel[i]);
        }
    }
}