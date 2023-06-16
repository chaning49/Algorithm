class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // prices의 맨 앞에 위치한 값부터 차례로 비교 후 개수 저장
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        
        return answer;
    }
}