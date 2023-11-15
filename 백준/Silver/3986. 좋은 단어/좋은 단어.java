import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 3986 좋은 단어
        * 입력: n, A와 B로만 이루어진 단어 n개 (단어의 길이는 2~100,000이고 모든 단어의 길이 합은 100만 이하)
        * 출력: 좋은 단어의 개수 출력
        * 단어 위로 선끼리 교차하지 않으면서 모두 쌍이 맺어지는지 체크해야 한다.
        * 90도로 세워보니 스택으로 풀어볼 수 있다는 점을 알게 됐다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stk = new Stack<>();
            for (char c : br.readLine().toCharArray()) {
                if (stk.isEmpty()) stk.push(c);
                else {
                    if (stk.peek() == c) stk.pop();
                    else stk.push(c);
                }
            }
            
            // 스택이 비어있다는 것이 모든 단어가 쌍을 이룬다는 의미이므로 좋은 단어이다.
            if (stk.isEmpty()) ans++;
        }

        System.out.println(ans);
    }
}