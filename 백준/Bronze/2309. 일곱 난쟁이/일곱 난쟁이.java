import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받으면서 총합 구하기
        int[] dwarf = new int[9];
        int target = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < dwarf.length; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            target += dwarf[i];
        }

        // 목표값
        target -= 100;

        // 오름차순 정렬
        Arrays.sort(dwarf);

        int[] idx = new int[2];

        // 앞에서부터 target을 찾기
        for (int i = 0; i < dwarf.length - 1; i++) {
            int sum = dwarf[i];
            for (int j = i + 1; j < dwarf.length; j++) {
                sum += dwarf[j];
                if (sum == target) {
                    idx[0] = i;
                    idx[1] = j;
                } else {
                    sum -= dwarf[j];
                }
            }
        }

        // 출력하기
        for (int i = 0; i < dwarf.length; i++) {
            if (i == idx[0] || i == idx[1]) continue;
            System.out.println(dwarf[i]);
        }
    }
}