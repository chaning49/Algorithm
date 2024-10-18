import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        // 양쪽에서 문자가 같은지 확인한다.
        int start = 0;
        int end = word.length - 1;
        while (start < end) {
            if (word[start] != word[end]) {
                System.out.println(0);
                return;
            }
            start++;
            end--;
        }
        System.out.println(1);
    }
}