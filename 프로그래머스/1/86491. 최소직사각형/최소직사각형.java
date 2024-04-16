import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0, h = 0;
        
        // sizes를 순회하면서 가로와 세로의 최대값 찾기(가로를 더 큰 값을 가지도록 설정)
        for (int[] size : sizes) {
            int wTemp = size[0];
            int hTemp = size[1];
            if (wTemp < hTemp) { // swap
                int temp = wTemp;
                wTemp = hTemp;
                hTemp = temp;
            }
            if (w < wTemp) w = wTemp;
            if (h < hTemp) h = hTemp;
        }
        
        answer = w * h;
        
        return answer;
    }
}