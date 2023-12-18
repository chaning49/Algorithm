import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] chars, password;
    public static void main(String[] args) throws IOException {
        /*
         * boj 1759 암호 만들기
         * 입력: 서로 다른 L개의 알파벳, C개의 문자들이 입력될 예정, C개의 문자들이 공백 한 칸을 두고 입력됨
         * 사전식 -> 오름차순 정렬 -> 배열이나 리스트를 사용하여 정렬해봐야겠다.
         * 가능성 있는 암호의 조합에 맞춰서 최소 한 개의 모음을 가져야 한다. -> 모음을 무조건 포함하는 단어를 만들 것
         * 출력: 사전식으로 가능성 있는 암호를 모두 출력한다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // L, C
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        password = new char[L];

        // alphabet
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        // asc
        Arrays.sort(chars);

        // recursion
        findPwd(0, 0);
        System.out.println(sb);
    }

    // 암호 찾기
    static void findPwd(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                sb.append(new String(password)).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = chars[i];
            findPwd(i + 1, depth + 1);
        }
    }

    // 자음 2개, 모음 1개를 만족하는지 판별
    static boolean isValid() {
        int cons = 0;
        int vowel = 0;

        for (char c : password) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                cons++;
            }
        }

        return cons >= 2 && vowel >= 1;
    }
}