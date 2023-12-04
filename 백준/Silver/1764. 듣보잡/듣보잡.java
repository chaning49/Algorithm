import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 1764 듣보잡
         * 듣도 보도 못한 사람의 명단을 구하는 문제
         * 입력: 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
         * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
         * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
         * 출력: 듣보잡의 수와 그 명단을 사전순으로 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Map을 선언, 이름과 듣거나 본 횟수를 저장
        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < n + m; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) > 1) { // value가 1 초과이면 듣보잡
                cnt++;
                names.add(str);
            }
        }

        // 듣보잡의 수와 이름을 사전순으로 저장
        Collections.sort(names);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (String a : names) {
            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }
}