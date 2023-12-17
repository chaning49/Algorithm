import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        /*
         * boj 7662 이중 우선순위 큐
         * 듣도 보도 못한 사람의 명단을 구하는 문제
         * 입력: 첫째 줄에는 TC 개수, 둘째 줄부터는 동작의 개수와 동작 + 숫자 입력
         * 연산의 개수는 100만 개, I는 입력, D는 삭제이고 알파벳 옆 1은 최대값, -1은 최소값
         * 출력: 남은 값 중에서 최대, 최소를 한 줄로 출력, 만약 비어있으면 EMPTY 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> q = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                // st의 첫 번째 값을 기준으로 동작을 선택
                if (c == 'I') {
                    q.put(num, q.getOrDefault(num, 0) + 1);
                } else {
                    if (q.isEmpty()) {
                        continue;
                    }
                    int target = (num == 1) ? q.lastKey() : q.firstKey();
                    int tNum = q.get(target);
                    if (tNum == 1) {
                        q.remove(target);
                    } else {
                        q.put(target, q.get(target) - 1);
                    }
                }
            }

            // 큐가 비어있는지 확인하여 최대값 최소값 순으로 출력
            if (q.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(q.lastKey()).append(" ").append(q.firstKey());
            }
            sb.append("\n");
            t--;
        }
        System.out.print(sb);
    }
}