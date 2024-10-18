import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선수의 알파벳 별 인원 수를 저장할 알파벳 배열 선언
        int[] alpha = new int[26];

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = br.readLine().charAt(0) - 'a';
            alpha[a]++;
        }

        // 5명인 경우의 알파벳을 오름차순으로 이어붙인다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alpha[i] >= 5) sb.append(Character.toChars('a' + i));
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "PREDAJA");
    }
}