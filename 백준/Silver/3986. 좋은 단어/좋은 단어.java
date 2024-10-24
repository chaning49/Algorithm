import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        // 순차적으로 스택에 알파벳을 넣으면서 같은 알파벳끼리 만나는 순간마다 제거
        while (n-- > 0) {
            char[] inputs = br.readLine().toCharArray();
            Stack<Character> stk = new Stack<>();
            for (char ch : inputs) {
                if (!stk.empty() && stk.peek() == ch) stk.pop();
                else stk.push(ch);
            }
            if (stk.empty()) ans++;
        }

        System.out.println(ans);
    }
}