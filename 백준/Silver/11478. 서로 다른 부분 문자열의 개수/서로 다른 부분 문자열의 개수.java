import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> subStr = new HashSet<>();

        int cnt = 0;
        while(cnt < str.length()) {
            int left = 0;
            for (int right = cnt; right < str.length(); left++, right++) {
                String temp = str.substring(left, right + 1);
                subStr.add(temp);
            }
            cnt++;
        }

        System.out.println(subStr.size());
    }
}