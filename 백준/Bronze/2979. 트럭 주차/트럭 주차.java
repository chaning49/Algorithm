import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        // 시간은 1부터 100
        int[] cnt = new int[101];

        // 입차가 일어난 시간을 기록해준다.
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int in = Integer.parseInt(input[0]);
            int out = Integer.parseInt(input[1]);
            for (int j = in; j < out; j++) {
                cnt[j]++;
            }
        }

        int ans = 0;
        for (int i = 1; i < 101; i++) {
            if (cnt[i] != 0) {
                if (cnt[i] == 1) ans += a;
                else if (cnt[i] == 2) ans += b * 2;
                else if (cnt[i] == 3) ans += c * 3;
            }
        }

        System.out.println(ans);
    }
}

