import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 10 이하인 경우는 n번째 감소하는 수가 n과 같다.
        if (n <= 10) {
            System.out.println(n);
            return;
        } else if (n >= 1023) { // 9876543210가 1022번째로 감소하는 수이다. 즉 1023번째 이상부터는 이 이상의 감소하는 수가 없다는 뜻
            System.out.println(-1);
            return;
        }

        // 0부터 9까지 시작하는 감소하는 수를 찾기 위해 i가 0~9까지 순회
        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }

        // 오름차순으로 정렬
        Collections.sort(list);
        System.out.println(list.get(n));
    }

    // idx는 자릿수, num은 감소하는 값이다.
    private static void dfs(long num, int idx) {
        if (idx > 10) {
            return;
        }

        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            dfs((num * 10) + i, idx + 1);
        }
    }
}
