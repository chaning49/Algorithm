class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        // land의 두번째 줄부터 값을 누적
        // 각 행의 열과 겹치지 않는 이전 행의 열에 위치한 값들 중, 최대값을 더한다.
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] += findMaxNum(land[i - 1], j);
            }
        }
        
        // 마지막 줄이 최종 결과이므로 그 중 최대를 구한다.
        for (int l : land[land.length - 1]) {
            answer = Math.max(answer, l);
        }
        
        return answer;
    }
    
    // 배열에서 특정 인덱스를 제외한 최대값을 구하는 메서드
    private int findMaxNum (int[] nums, int idx) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == idx) {
                continue;
            }
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}