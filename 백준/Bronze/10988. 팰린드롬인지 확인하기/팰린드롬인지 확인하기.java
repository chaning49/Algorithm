import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 입력은 소문자, 길이는 1 이상 100 이하
        * 출력은 팰린드롬이면 1, 아니면 0
        * 어느 방향에서 읽어도 같은 순서인 단어를 팰린드롬이라고 한다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}

