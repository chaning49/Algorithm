import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 최소 거리 저장
        int ans = 0;
        
        // n, m 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 사과의 개수 j
        int j = Integer.parseInt(br.readLine());
        
        // 왼쪽과 오른쪽 값 초기화
        int l = 1;
        int r;
        
        // 입력된 사과의 개수만큼 이동한 거리 계산
        for (int i = 0; i < j; i++) {
            r = l + m - 1; // 왼쪽 + 오른쪽 - 1을 해야 길이가 m에 맞춰진다.
            int loc = Integer.parseInt(br.readLine());
            if (loc >= l && loc <= r) continue; // 움직이지 않아도 되는 위치
            else {
                if (loc < l) { // l이 내려오는 사과보다 오른쪽에 위치한 경우
                    ans += (l - loc);
                    l = loc;
                } else { // l이 내려오는 사과보다 왼쪽에 위치한 경우
                    ans += (loc - r);
                    l += (loc - r);
                }
            }
        }
        
        System.out.println(ans);
    }
}