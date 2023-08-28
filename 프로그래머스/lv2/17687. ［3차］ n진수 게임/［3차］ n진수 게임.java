class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = ""; 
        String[] alpha = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"}; // 각 인덱스에 해당하는 수 표현을 위한 배열
        StringBuilder sb = new StringBuilder(); // 필요한 개수의 숫자를 저장하기 위한 StringBuilder
        sb.append(0).append(1); // 0, 1은 2진수부터 모두 들어가는 값이기 때문에 넣어두고 시작
        int num = 2;
        
        // 최소 t * m이 sb의 길이가 되어야 필요한 결과값을 만들 수 있다.
        while (sb.length() <= t * m) {
            int number = num;
            StringBuilder temp = new StringBuilder();
            while (number > 0) {
                temp.insert(0, alpha[number % n]); // 진법에 맞는 수 이어붙이면서 몫이 0이 될때까지 반복
                number /= n;
            }
            sb.append(temp);
            num++;
        }
        
        // 튜브의 순서를 고려한 문자열 이어붙이기
        for (int i = 0; i < t; i++) {
            answer += sb.charAt(i * m + p - 1);
        }
        
        return answer;
    }
}