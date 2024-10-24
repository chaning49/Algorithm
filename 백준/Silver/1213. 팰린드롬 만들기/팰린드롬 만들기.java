import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        // 포함된 알파벳의 개수 세기
        int[] alpha = new int[26];
        for (char ch : input) {
            alpha[ch - 'A']++;
        }

        // 알파벳의 개수가 홀수인 알파벳이 2개 이상이면 팰린드롬 불가능
        int checkPal = 0;
        int midNum = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                checkPal++;
                midNum = i;
            }
            if (checkPal == 2) break;
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) ('A' + i));
            }
        }

        // 거꾸로 붙이기
        StringBuilder sbRev = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            sbRev.append(sb.charAt(i));
        }

        // checkPal의 값에 따라 가운데 값을 이어붙이거나, Sorry 등 출력값 반환
        if (checkPal == 1) sb.append((char) ('A' + midNum));
        if (checkPal == 2) System.out.println("I'm Sorry Hansoo");
        else System.out.println(sb.append(sbRev));
    }
}