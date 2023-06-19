class Solution {
    public int solution(int n, int m, int[] section) {
        // 최소 하나 이상 칠해야 하며 roller의 시작점을 section의 첫 원소로 정해준다.
        int answer = 1;
        int roller = section[0];
        
        // 앞에서부터 roller에 m만큼 더한 값 - 1이 roller로 칠해질 수 있는 범위이다. 해당 값이 section[i]보다 작으면 1회 칠할 수 있으므로 answer를 증가시키고 section[i]를 roller의 시작점으로 만든다.
        for (int i = 1; i < section.length; i++) {
            if (roller + m - 1 < section[i]) {
                answer++;
                roller = section[i];
            }
        }
        
        return answer;
    }
}