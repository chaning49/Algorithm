import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 9996 한국이 그리울 땐 서버에 접속하지
        * 패턴: 알파벳 소문자 여러개 + *
        * 패턴과 파일 이름이 주어지고 각각의 파일 이름이 패턴과 일치하는지 알아보자
        * 입력: n(1 <= n <= 100), pattern(알파벳 소문자 + *(아스키값 42), 길이는 100이하, 별표는 문자열의 처음, 끝 불가), fileNames
        * 출력: 파일 이름에 따라 패턴과 일치하면 DA, 아니면 NE
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        // pattern의 시작, 끝 문자열을 저장
        int star = pattern.indexOf("*");
        String pre = pattern.substring(0, star);
        String suf = pattern.substring(star + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (pre.length() + suf.length() > str.length()) { // 반례: ab인 경우까지 고려해야 한다.
                sb.append("NE").append("\n");
            } else {
                if (pre.equals(str.substring(0, pre.length())) && suf.equals(str.substring(str.length() - suf.length()))) {
                    sb.append("DA").append("\n");
                } else {
                    sb.append("NE").append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}