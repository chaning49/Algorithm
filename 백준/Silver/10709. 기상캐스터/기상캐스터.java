import java.io.*;
import java.util.*;

public class Main {
    static int[][] joi;
    static int h, w;
    static int num;
    static boolean checkC;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            checkC = false;
            for (int j = 0; j < w; j++) {
                char ch = input.charAt(j);
                if (ch == 'c') {
                    ansPrint(j, 0);
                    num = 0;
                    checkC = true;
                } else if (ch == '.') {
                    if (checkC) {
                        ansPrint(j, ++num);
                    } else {
                        ansPrint(j, -1);
                    }
                }
            }
            if (i < h - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    
    // StringBuilder 이어붙이기
    private static void ansPrint(int j, int num) {
        if (j == w - 1) {
            sb.append(num);
        } else {
            sb.append(num).append(" ");
        }
    }
}