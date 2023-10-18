import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nge = new int[n];
        int[] answer = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            nge[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nge[stk.peek()] < nge[i]) {
                answer[stk.pop()] = nge[i];
            }
            stk.push(i);
        }

        if (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);
    }
}
