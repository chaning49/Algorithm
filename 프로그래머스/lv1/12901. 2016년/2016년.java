class Solution {
    public String solution(int a, int b) {
        // 날짜와 한 달의 날짜를 저장할 배열 생성
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String answer = "";
        
        // a월 b일의 날짜 수를 저장할 변수 선언
        int day = 0;
        
        // a월까지의 날짜 + b일 합치기
        for (int i = 1; i < a; i++) {
            day += months[i];
        }
        day += b;
        
        // 날짜를 요일의 개수인 7로 나눈 나머지에 해당하는 인덱스가 요일이 된다.
        day %= 7;
        answer = days[day];
        
        return answer;
    }
}