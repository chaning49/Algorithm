import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boj 9375 패션왕 신해빈
        * 입력: 테스트 케이스, 의상의 수와 종류
        * 출력: 섞어서 입을 수 있는 경우의 수
        * 착용할 아이템의 종류가 몇 개인지만 저장하면 된다. 예시를 보면 쉽게 알 수 있다.
        * head 2개, eye 1개 -> 경우의 수는 곱셈이다. 이 때, 착용하지 않는 경우까지 고려하면 각 아이템에 +1씩 해준 후 곱한 다음 둘다 착용하지 않는 경우를 -1
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 테스트케이스 만큼 반복
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] inputs = br.readLine().split(" ");
                if (!map.containsKey(inputs[1])) {
                    map.put(inputs[1], 1);
                } else {
                    map.put(inputs[1], map.get(inputs[1]) + 1);
                }
            }

            long ans = 1;
            for (String key : map.keySet()) {
                ans *= (map.get(key) + 1);
            }
            ans--;

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}