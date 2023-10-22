import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            // 종료조건인 . 하나의 경우 종료
            if (str.equals(".")) {
                break;
            }

            sb.append(solution(str)).append("\n");
        }

        System.out.println(sb);
    }

    public static String solution(String str) {
        Stack<Character> stk = new Stack<>();

        // 입력된 문장을 한 글자씩 확인하면서 괄호의 규칙에 따라 체크
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stk.push(c);
            }  else if (c == ')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    return "no";
                } else {
                    stk.pop();
                }
            } else if (c == ']') {
                if (stk.isEmpty() || stk.peek() != '[') {
                    return "no";
                } else {
                    stk.pop();
                }
            }
        }

        if (stk.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
