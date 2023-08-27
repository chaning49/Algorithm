class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        // 1 -> 2 -> 4 순서로 값이 바뀐다. 
        // 1, 2, 4, 11, 12, 14, 21, 22, 24, 41, 42, 44, 111, 112, 114, 121, 122, 124, 141, 142, 144, 211, ...
        // 3개가 반복 -> 나머지는 1, 2, 0이지만 124 나라는 3으로 나눠서 1, 2, 4가 나와야 함
        // 3진법의 3 -> 10, 124 나라의 3 -> 4이므로 불필요한 연산을 줄이기 위해서는 n이 3으로 나누어 떨어지는 수의 몫 - 1을 다시 n으로
        // 그냥 while문으로 String에 값을 추가했더니 효율성에서 실패
        // StringBuilder의 insert를 사용해서 앞으로 값을 추가하는 방식 채택
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            
            if (remainder == 0) {
                remainder = 4;
                n -= 1;
            }
            
            answer.insert(0, remainder);
        }
        
        return answer.toString();
    }
}