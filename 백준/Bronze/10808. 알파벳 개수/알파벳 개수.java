import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 알파벳의 개수를 저장할 배열 선언
        int[] alpha = new int[26];

        // 단어 입력으로 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        // 단어 하나씩 키워카면서 인덱스 저장
        for (char c : str) {
            alpha[c - 'a']++;
        }
        
        // 출력
        for(int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}