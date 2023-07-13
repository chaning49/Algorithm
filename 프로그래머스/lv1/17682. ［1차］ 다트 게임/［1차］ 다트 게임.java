class Solution {
    public int solution(String dartResult) {
        int answer = 0;  // 최종 점수를 저장할 변수
        int[] score = new int[3];  // 각 회차의 점수를 저장할 배열
        int idx = 0;  // 현재 진행중인 회차를 가리키는 인덱스

        // 문자열의 각 문자를 확인하면서 점수를 계산
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            // 숫자인 경우 점수를 저장
            if(Character.isDigit(c)) {
                // 점수가 10인 경우 다음 문자도 확인
                if(c == '1' && dartResult.charAt(i+1) == '0') {
                    score[idx] = 10;
                    i++;  // 다음 문자도 확인했으므로 i를 1 증가
                } else {
                    // 점수가 10이 아닌 경우 해당 숫자를 점수로 저장
                    score[idx] = c - '0';
                }
            // 보너스인 경우 해당 보너스에 따라 점수를 조정
            } else if(c == 'D') {
                // Double의 경우 점수를 제곱
                score[idx] = (int) Math.pow(score[idx], 2);
                idx++;  // 다음 회차로 이동
            } else if(c == 'T') {
                // Triple의 경우 점수를 세제곱
                score[idx] = (int) Math.pow(score[idx], 3);
                idx++;  // 다음 회차로 이동
            } else if(c == 'S') {
                // Single의 경우 점수 변동 없음
                idx++;  // 다음 회차로 이동
            // 옵션인 경우 해당 옵션에 따라 점수를 조정
            } else if(c == '*') {
                // 스타상의 경우 현재 회차와 이전 회차 점수 2배
                if(idx > 1) {
                    score[idx-2] *= 2;
                }
                score[idx-1] *= 2;
            } else if(c == '#') {
                // 아차상의 경우 현재 회차 점수 마이너스
                score[idx-1] *= -1;
            }
        }

        // 각 회차의 점수를 모두 더해 최종 점수 계산
        for(int s : score) {
            answer += s;
        }

        return answer;  // 최종 점수 반환
    }
}
