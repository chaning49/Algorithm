import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n, m
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 이름만 저장할 리스트
        List<String> pokemonList = new ArrayList<>();

        // 이름과 번호 저장용 Map
        Map<String, Integer> pokemonMap = new HashMap<>();

        // n개의 포켓몬 저장
        for (int i = 0; i < n; i++) {
            String tempName = br.readLine();
            pokemonList.add(tempName);
            pokemonMap.put(tempName, i + 1);
        }

        // m개의 문제를 입력받으면서 정답을 동시에 저장
        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (isNumeric(q)) {
                int idx = Integer.parseInt(q) - 1;
                sb.append(pokemonList.get(idx)).append("\n");
            } else {
                sb.append(pokemonMap.get(q)).append("\n");
            }
        }

        System.out.println(sb);
    }

    // 문자열이 숫자인지 확인
    private static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
