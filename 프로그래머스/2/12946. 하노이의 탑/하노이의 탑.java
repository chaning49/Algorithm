import java.util.*;

class Solution {
    static List<int[]> path;
    
    public int[][] solution(int n) {
        path = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        return path.toArray(new int[path.size()][2]);
    }
    
    public void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            path.add(move(from, to));
            return;
        }
        
        hanoi(n - 1, from, via, to);
        path.add(move(from, to));
        hanoi(n - 1, via, to, from);
    }
    
    private int[] move(int from, int to) {
        return new int[]{from, to};
    }
}