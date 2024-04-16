import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int mxw = 0, mxh = 0;
        
        // 회전하면서 가로와 세로의 최대값 찾기(가로를 더 큰 값을 가지도록 설정)
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            mxw = Math.max(mxw, w);
            mxh = Math.max(mxh, h);
        }
        
        return mxw * mxh;
    }
}