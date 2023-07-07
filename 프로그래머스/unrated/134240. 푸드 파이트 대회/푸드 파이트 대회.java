class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        // food를 순회하면서 홀수개인 음식을 하나씩 낮춘 다음 한 사람의 음식 순서를 붙인다.
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                food[i]--;
            }
            answer += Integer.toString(i).repeat(food[i] / 2);
        }
        
        // 한 사람의 음식 순서의 역순을 저장
        StringBuffer sb = new StringBuffer(answer);
        String reverseAns = sb.reverse().toString();
        
        // 0과 역순을 이어붙인다.
        answer += "0" + reverseAns;
        
        return answer;
    }
}