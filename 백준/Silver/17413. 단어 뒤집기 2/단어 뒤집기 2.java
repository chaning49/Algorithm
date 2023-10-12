import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isTag = false;

        for (char c : s.toCharArray()) {
            if (c == '<') {
                answer.append(temp.reverse());
                temp.setLength(0);  // StringBuilder 초기화
                isTag = true;
            }

            if (isTag) {
                temp.append(c);
            } else if (c == ' ') {
                answer.append(temp.reverse()).append(c);
                temp.setLength(0);
            } else {
                temp.append(c);
            }

            if (c == '>') {
                answer.append(temp);
                temp.setLength(0);
                isTag = false;
            }
        }

        // 남아있는 단어 처리
        answer.append(temp.reverse());

        System.out.println(answer);
    }
}
