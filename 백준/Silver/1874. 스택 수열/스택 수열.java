import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int currNum = 1;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (currNum <= target) {
                stk.push(currNum++);
                sb.append("+").append("\n");
            }

            if (stk.isEmpty() || stk.peek() != target) {
                isPossible = false;
                break;
            }

            stk.pop();
            sb.append("-").append("\n");
        }

        if (isPossible)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
