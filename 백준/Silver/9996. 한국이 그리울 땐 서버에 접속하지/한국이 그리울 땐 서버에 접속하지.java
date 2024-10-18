import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 특수문자 *을 기준으로 앞의 패턴과 뒤의 패턴을 저장
        String pattern = br.readLine();
        int starIdx = pattern.indexOf('*');
        String pre = pattern.substring(0, starIdx);
        String suf = pattern.substring(starIdx + 1);

        // 입력된 문자열이 패턴과 일치하는지 확인
        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            boolean hasPattern = true;
            
            // 파일 이름이 패턴 길이의 합보다 작으면 매칭 불가능
            if (fileName.length() < pre.length() + suf.length()) hasPattern = false;
            if (!fileName.startsWith(pre)) hasPattern = false;
            if (!fileName.endsWith(suf)) hasPattern = false;

            System.out.println(hasPattern ? "DA" : "NE");
        }
    }
}