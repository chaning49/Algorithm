import java.util.*;
import java.io.*;

public class Main {
    static boolean isAcceptable;
    static final String ACCEPTABLE = "> is acceptable.\n";
    static final String NOT_ACCEPTABLE = "> is not acceptable.\n";
    static String str;
    static char prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            str = br.readLine();
            
            // 종료 조건
            if (str.equals("end")) {
                break;
            }

            isAcceptable = false;
            prev = '0'; // 이전 문자 초기화
            int consonants = 0; // 자음의 개수
            int vowels = 0; // 모음의 개수

            for (char c : str.toCharArray()) {
                if (isVowel(c)) { // 모음인 경우
                    isAcceptable = true;
                    vowels++;
                    consonants = 0;
                } else { // 자음인 경우
                    vowels = 0;
                    consonants++;
                }
                
                // 자음 또는 모음이 3개 연속인 경우 -> not acceptable
                if (consonants == 3 || vowels == 3) {
                    isAcceptable = false;
                    break;
                }
                
                // 이전 문자와 현재 문자가 같고, ee 또는 oo가 아닌 경우 -> not acceptable
                if (c == prev && c != 'e' && c!= 'o') {
                    isAcceptable = false;
                    break;
                }
                
                // 통과하면 현재 문자를 이전 문자로 변경
                prev = c;
            }
            if (isAcceptable) sb.append("<").append(str).append(ACCEPTABLE);
            else sb.append("<").append(str).append(NOT_ACCEPTABLE);
        }

        System.out.println(sb);
    }
    
    // 모음인지 판별
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}