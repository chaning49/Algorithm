import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 11655 ROT13
        * ROT13: 알파벳 대소문자를 13글자씩 밀어서 만든다.
        * 입력: 알파벳 대문자, 소문자, 공백, 숫자, 길이는 1 ~ 100
        * 출력: ROT13이 적용된 문자열
        * A: 65, a: 97을 외우면 편해진다!
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        // 문자를 하나씩 비교해서 이어붙여준다
        for (char c : s.toCharArray()) {
            // 알파벳인 경우만 고려
            if (c >= 'a' && c <= 'z') { // 소문자
                char rot13 = (char) ((c - 'a' + 13) % 26 + 'a');
                sb.append(rot13);
            } else if (c >= 'A' && c <= 'Z') { // 대문자
                char rot13 = (char) ((c - 'A' + 13) % 26 + 'A');
                sb.append(rot13);
            } else { // 나머지는 그냥 이어붙이기
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}