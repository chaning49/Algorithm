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

            if (str.equals("end")) {
                break;
            }

            isAcceptable = false;
            prev = '0';
            int vowels = 0;
            int consonants = 0;

            for (char c : str.toCharArray()) {
                if (isVowel(c)) {
                    isAcceptable = true;
                    vowels++;
                    consonants = 0;
                } else {
                    vowels = 0;
                    consonants++;
                }

                if (consonants == 3 || vowels == 3) {
                    isAcceptable = false;
                    break;
                }

                if (c == prev && c != 'e' && c!= 'o') {
                    isAcceptable = false;
                    break;
                }

                prev = c;
            }
            if (isAcceptable) sb.append("<").append(str).append(ACCEPTABLE);
            else sb.append("<").append(str).append(NOT_ACCEPTABLE);
        }

        System.out.println(sb);
    }
    
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}