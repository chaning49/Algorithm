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
        int[] truck = new int[101];
        int[] inArr = new int[101];
        int[] outArr = new int[101];

        // 같은 시간이 in or out인 경우도 생각해줘야 한다.
        // 입력된 입차, 출차 값을 times의 인덱스에 in, out으로 표시한다.
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int in = Integer.parseInt(input[0]);
            int out = Integer.parseInt(input[1]);
            inArr[in]++;
            outArr[out]++;
        }

        int ans = 0;
        for (int i = 1; i < 101; i++) {
            if (inArr[i] == 0 && outArr[i] == 0) {
                truck[i] = truck[i - 1];
            } else {
                truck[i] = truck[i - 1] + inArr[i] - outArr[i];
            }
            switch (truck[i]) {
                case 1:
                    ans += a;
                    break;
                case 2:
                    ans += b * 2;
                    break;
                case 3:
                    ans += c * 3;
                    break;
            }
        }
        System.out.println(ans);
    }
}

