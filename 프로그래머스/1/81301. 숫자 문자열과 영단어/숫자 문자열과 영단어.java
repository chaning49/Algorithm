class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 각 인덱스에 해당하는 문자열 배열을 만든다.
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}