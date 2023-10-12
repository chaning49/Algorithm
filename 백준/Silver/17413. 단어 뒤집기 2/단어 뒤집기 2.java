import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        boolean isTag = false;

        // 1. < 문자가 등장하기 전까지는 뒤집어서 이어붙인다.
        // 2. < 문자가 등장하면 > 문자까지 태그이므로 그대로 이어붙인다.
        // 3. > 문자 이후로 다시 < 문자를 만날 때까지는 뒤집어서 이어붙인다.

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!temp.toString().equals("")) {
                    sb.append(temp.reverse());
                    temp.setLength(0);
                }
                isTag = true;
            } else if (str.charAt(i) == '>') {
                isTag = false;
                sb.append(temp).append(">");
                temp.setLength(0);
                continue;
            }

            if (isTag) {
                temp.append(str.charAt(i));
            } else {
                if (str.charAt(i) == ' ') {
                    sb.append(temp.reverse()).append(" ");
                    temp.setLength(0);
                } else {
                    temp.append(str.charAt(i));
                }
            }
        }

        if (temp.length() != 0) {
            sb.append(temp.reverse());
        }

        System.out.println(sb);
    }
}