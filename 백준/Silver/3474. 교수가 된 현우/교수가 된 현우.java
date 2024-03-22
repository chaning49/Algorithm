import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int num2 = 0;
            int num5 = 0;
            for (int j = 2; j <= n; j *= 2) {
                num2 += n / j;
            }
            for (int j = 5; j <= n; j *= 5) {
                num5 += n / j;
            }
            sb.append(Math.min(num2, num5));
            if (i + 1 < t) sb.append("\n");
        }

        System.out.println(sb);
    }
}