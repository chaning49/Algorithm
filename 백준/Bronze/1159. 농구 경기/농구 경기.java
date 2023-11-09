import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 입력 선수의 수 n은 1부터 150까지, n개의 줄에는 선수의 성이 주어진다.(알파벳 소문자)
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 알파벳 개수 저장
        int[] alpha = new int[26];

        for (int i = 0; i < n; i++) {
            char c = br.readLine().charAt(0);
            alpha[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] >= 5) {
                char c = (char) ('a' + i);
                sb.append(c);
            }
        }

        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}