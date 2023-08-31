import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // N, E, S, W 순서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        List<String> directions = Arrays.asList("N", "E", "S", "W");
        
        int x = 0;
        int y = 0;
        
        // 시작 위치 설정하기
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf("S");
                break;
            }
        }
        
        // 방향과 거리를 확인했을 때, 공원의 범위를 벗어나거나 경로에 X가 있으면 이동하지 않는다.
        for (String r : routes) {
            String[] route = r.split(" ");
            String dir = route[0];
            int distance = Integer.parseInt(route[1]);
            
            int idx = directions.indexOf(dir);
            
            int prevX = x;
            int prevY = y;
            
            for (int d = 0; d < distance; d++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                
                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length() || park[nx].charAt(ny) == 'X') {
                    x = prevX;
                    y = prevY;
                    break;
                }
                
                x = nx;
                y = ny;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}