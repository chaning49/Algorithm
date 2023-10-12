import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            alpha[num] += 1;
        }

        int maxNum = -1;
        char ans = '?';

        for (int i = 0; i < alpha.length; i++) {
            if (maxNum == alpha[i]) ans = '?';
            else if (maxNum < alpha[i]) {
                maxNum = alpha[i];
                ans = (char) (i + 'A');
            }
        }

        System.out.println(ans);
    }
}