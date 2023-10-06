import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // n 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1이면 그대로 반환
        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }

        // n 크기만큼의 배열 선언
        String[] strArr = new String[n];

        // 배열에 문자열 담기
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        // 글자수의 0번째부터 마지막 글자까지 비교하기, boolean 변수를 사용하여 같은지 다른지 확인한 다음 정답 문자열에 하나씩 붙인다.
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String str = strArr[0];
        while (idx < str.length()) {
            boolean isSame = true;
            for (int i = 1; i < strArr.length; i++) {
                if (str.charAt(idx) != strArr[i].charAt(idx)) {
                    sb.append("?");
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                sb.append(str.charAt(idx));
            }
            idx++;
        }

        System.out.println(sb);
    }
}