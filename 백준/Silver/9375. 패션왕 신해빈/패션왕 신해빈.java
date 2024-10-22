import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 총 n회의 시행
        for (int i = 0; i < n; i++) {
            int tc = Integer.parseInt(br.readLine());
            // 자료구조 뭐 쓰지? map?
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < tc; j++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            long ans = 1;
            for (String str : map.keySet()) {
                ans *= (map.get(str) + 1);
            }
            System.out.println(ans - 1);
        }
    }
}