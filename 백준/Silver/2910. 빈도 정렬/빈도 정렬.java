import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * boj 2910 빈도 정렬
         * 입력: 첫째 줄에 메시지의 길이 N과 C가 주어진다. (1 <= N <= 1000, 1 <= C <= 1000000000)
         * 출력: 메시지 수열
         * 빈도 수를 저장할 Map frequencyMap, 순서를 저장할 Map orderMap, 입력된 수를 저장하고 정렬할 리스트 numbers
         * Collections.sort()를 커스텀하여 빈도수 순으로 내림차순 정렬, 입력 순서를 기반으로 오름차순 정렬
         * sort에서 a, b를 그냥 사용하면 NPE가 발생한다. 그 이유는 map.get(a)에서 키인 a가 존재하지 않는 경우 null이 발생하기 때문에 equals 메서드에서 NPE를 발생시키기 때문이다.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> frequencyMap = new HashMap<>(); // 빈도 수 저장
        Map<Integer, Integer> orderMap = new HashMap<>(); // 입력 순서
        int idx = 1;
        List<Integer> numbers = new ArrayList<>(); // 수를 저장할 리스트

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            numbers.add(num); // 수 저장

            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // 빈도 수 저장

            if (!orderMap.containsKey(num)) { // 같은 수의 입력된 첫 순서만을 기록하기 위해 값이 0인 경우에만 사용
                orderMap.put(num, idx);
                idx++;
            }
        }

        numbers.sort((a, b) -> {
            int cntA = frequencyMap.getOrDefault(a, 0);
            int cntB = frequencyMap.getOrDefault(b, 0);

            int orderA = orderMap.getOrDefault(a, 0);
            int orderB = orderMap.getOrDefault(b, 0);

            if (cntA == cntB) { // 빈도 수가 같은 경우에는 입력 순서의 오름차순으로 정렬
                return orderA - orderB;
            }
            return cntB - cntA; // 빈도 수에 따라 내림차순으로 정렬
        });

        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}