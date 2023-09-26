import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input을 String 타입으로 입력받기
        String input = sc.nextLine();

        // 크기가 26인 int 배열을 선언(알파벳의 순서)
        int[] alpha = new int[26];

        // 알파벳을 하나씩 순회하면서 알파벳의 위치에 해당하는 값을 1씩 증가시킨다.
        for (char c : input.toCharArray()) {
            alpha[c - 'a']++;
        }

        // 한 줄에 출력하기
        for (int i = 0; i < alpha.length; i++) {
            if (i == 25) {
                System.out.print(alpha[i]);
            } else {
                System.out.print(alpha[i] + " ");
            }
        }

        sc.close();
    }
}