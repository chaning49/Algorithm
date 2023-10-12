import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);

            if (sb.length() >= bomb.length && sb.substring(sb.length() - bomb.length).equals(String.valueOf(bomb))) {
                sb.setLength(sb.length() - bomb.length);
            }
        }

        System.out.println(sb.length() > 0 ? sb.toString(): "FRULA");
    }
}
