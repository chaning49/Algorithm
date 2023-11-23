class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 사각형의 x + y가 둘레이므로 격자의 가로와 세로를 구할 수 있다.
        int sum = brown + yellow;
        
        // 둘레의 약수를 구한다. 이 때, 노란색 격자가 존재하는 최소 크기는 가로, 세로 모두 3이기 때문에 3 이상부터 확인
        for (int i = 3; i < sum; i++) {
            // 세로는 i, 가로는 x
            int x = sum / i;
            if (x >= i) {
                if ((i - 2) * (x - 2) == yellow) { // 나온 좌표에서 각각 2씩 제거한 값을 곱하면 노란색 격자의 넓이가 되어야 한다.
                    answer[0] = x;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}