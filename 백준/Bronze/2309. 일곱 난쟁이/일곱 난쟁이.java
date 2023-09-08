import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        // 숫자 입력 받기
        int[] hobits = new int[9];
        for (int i = 0; i < 9; i++) {
            hobits[i] = sc.nextInt();
            sum += hobits[i];
        }

        // 오름차순 정렬
        Arrays.sort(hobits);

        // 왼쪽부터 두 개씩 골라 sum에서 빼준다.
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1;  j < 9; j++) {
                if (sum - hobits[i] - hobits[j] == 100) {
                    for (int h : hobits) {
                        if (h != hobits[i] && h != hobits[j]) {
                            System.out.println(h);
                        }
                    }
                    return;
                }
            }
        }
    }
}
