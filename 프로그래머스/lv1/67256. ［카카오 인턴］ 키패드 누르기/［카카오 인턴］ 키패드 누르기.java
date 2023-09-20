class Solution {
    // 2D 좌표로 키패드를 표현
    private int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2},
                              {1, 0}, {1, 1}, {1, 2},
                              {2, 0}, {2, 1}, {2, 2},
                              {3, 0}, {3, 2}};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // 왼손과 오른손의 현재 위치 체크
        int leftThumb = 10; // '*'에 해당하는 위치
        int rightThumb = 11; // '#'에 해당하는 위치

        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer.append("L");
                    leftThumb = number;
                    break;
                case 3:
                case 6:
                case 9:
                    answer.append("R");
                    rightThumb = number;
                    break;
                default: // 2, 5, 8, 0
                    if (checkCloseThumb(leftThumb, rightThumb, number, hand)) {
                        answer.append("L");
                        leftThumb = number;
                    } else {
                        answer.append("R");
                        rightThumb = number;
                    }
                    break;
            }
        }

        return answer.toString();
    }

    // 왼쪽 엄지가 더 가까우면 true, 아니면 false 반환
    private boolean checkCloseThumb(int leftThumb, int rightThumb, int number, String hand) {
        int leftDistance = distanceOfThumb(leftThumb, number);
        int rightDistance = distanceOfThumb(rightThumb, number);

        if (leftDistance > rightDistance) {
            return false;
        } else if (leftDistance < rightDistance) {
            return true;
        } else {
            return hand.equals("left");
        }
    }

    // 현재 엄지의 위치와 number의 거리를 반환
    private int distanceOfThumb(int thumb, int number) {
        return Math.abs(keypad[thumb][0] - keypad[number][0]) + Math.abs(keypad[thumb][1] - keypad[number][1]);
    }
}
