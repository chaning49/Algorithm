import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 1213 팰린드롬 만들기
        * 입력: 알파벳 대문자 최대 50자
        * 출력: 팰린드롬 or I'm sorry Hansoo
        * 1. 알파벳이 홀수개가 되려면 하나만 있어야 한다. 또한 홀수개가 있는 알파벳이 가운데로 오도록 해야 한다.
        * 2. 알파벳의 뒷 순서부터 양쪽으로 이어붙여야 한다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        // 알파벳 직접 저장
        int[] alpha = new int[300];
        for (char c : name.toCharArray()) {
            alpha[c]++;
        }

        StringBuilder sb = new StringBuilder();
        char mid = '0';
        int oddCheck = 0;

        // 알파벳이 홀수개인 경우가 2개 이상이면 팰린드롬이 될 수 없다.
        for (int i = 'Z'; i >= 'A'; i--) {
            if (alpha[i] != 0) {
                if (alpha[i] % 2 == 1) { // 가운데 값이 존재하는 것이므로 mid에 알파벳 저장, oddCheck 증가, 알파벳 개수 차감
                    mid = (char) i;
                    oddCheck++;
                    alpha[i]--;
                }
                if (oddCheck == 2) break;
                for (int j = 0; j < alpha[i]; j += 2) { // 앞 뒤로 이어붙이기
                    sb.insert(0, (char) i);
                    sb.append((char) i);
                }
            }
        }

        if (oddCheck == 1) sb.insert(sb.length() / 2, mid); // 가운데에 집어넣기
        if (oddCheck == 2) System.out.println("I'm Sorry Hansoo");
        else System.out.println(sb);
    }
}