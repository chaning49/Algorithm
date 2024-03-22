class Solution {
    public int[] solution(int n, long left, long right) {
        // 정답에 필요한 크기의 배열 선언
        int[] answer = new int[(int)(right - left + 1)];
        
        // n x n 배열은 불가능, 시간복잡도가 너무 크다.
        // left ~ right까지만 계산하기 위한 규칙 찾기
        // ex. left = 2, 2 / n은 행, 2 % n은 열이 된다. -> (0, 2)이므로 0, 1, 2에서 3번째 순서로 일치한다.
        for (long i = left; i <= right; i++) {
            // i인덱스에 맞는 2차원 배열의 행, 열값 구하기
            int row = (int)(i / n);
            int col = (int)(i % n);
            
            // 행과 열의 값 중 큰 값에 1을 더하면 2차원 배열의 인덱스가 나온다.
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}