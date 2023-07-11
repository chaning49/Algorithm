import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        // 0부터 9까지 개수를 저장할 배열 선언
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        // 존재하는 숫자의 값으로 배열의 인덱스 개수를 증가시켜준다.
        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            xArr[c - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            yArr[c - '0']++;
        }
        
        // 뒤에서부터 내려오면서 X와 Y에 있는 값의 개수를 비교해서 숫자를 붙여준다.
        // 만약 한쪽에만 존재한다면 0이기 때문에 값이 없는 것으로 판별할 수 있다.
        for(int i = 9; i >= 0; i--)
            for (int j = 0; j < Math.min(xArr[i], yArr[i]); j++)
                sb.append(i);
        
        // 크기가 0이라면 -1, sb의 시작값이 0이면 0, 나머지의 경우는 정답을 반환한다.
        if (sb.length() == 0) return "-1";
        else if ("0".equals(sb.substring(0, 1))) return "0";
        else return sb.toString();
    }
}