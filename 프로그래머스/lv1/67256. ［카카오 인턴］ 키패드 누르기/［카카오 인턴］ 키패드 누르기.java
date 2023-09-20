class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 왼손과 오른손의 현재 위치 체크
        String leftThumb = "*";
        String rightThumb = "#";
        
        // numbers를 하나씩 순회하면서 왼손, 오른손을 체크한다.
        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    leftThumb = Integer.toString(number);
                    break;
                case 3:
                case 6:
                case 9:
                    answer += "R";
                    rightThumb = Integer.toString(number);
                    break;
                default: // 2, 5, 8, 0
                    String direction = checkCloseThumb(leftThumb, rightThumb, number, hand);
                    if (direction.equals("L")) {
                        answer += "L";
                        leftThumb = Integer.toString(number);
                    } else {
                        answer += "R";
                        rightThumb = Integer.toString(number);
                    }
                    break;
            }
        }
        
        return answer;
    }
    
    // 왼쪽 엄지와 오른쪽 엄지 중 가까운 곳을 찾아서 "L" 또는 "R" 반환
    private String checkCloseThumb(String leftThumb, String rightThumb, int number, String hand) {
        int leftDistance = distanceOfThumb(leftThumb, number);
        int rightDistance = distanceOfThumb(rightThumb, number);
        
        if (leftDistance > rightDistance) {
            return "R";
        } else if (leftDistance < rightDistance) {
            return "L";
        } else {
            return hand.equals("left") ? "L" : "R";
        }
    }
    
    // 현재 엄지의 위치와 number의 거리를 반환
    private int distanceOfThumb(String thumb, int number) {
        int distance = 0;
        switch (thumb) {
            case "1":
            case "2":
            case "3":
                if (number == 2) {
                    distance = thumb.equals("2") ? 0 : 1;
                } else if (number == 5) {
                    distance = thumb.equals("2") ? 1 : 2;
                } else if (number == 8) {
                    distance = thumb.equals("2") ? 2 : 3;
                } else {
                    distance = thumb.equals("2") ? 3 : 4;
                }
                break;
            case "4":
            case "5":
            case "6":
                if (number == 2) {
                    distance = thumb.equals("5") ? 1 : 2;
                } else if (number == 5) {
                    distance = thumb.equals("5") ? 0 : 1;
                } else if (number == 8) {
                    distance = thumb.equals("5") ? 1 : 2;
                } else {
                    distance = thumb.equals("5") ? 2 : 3;
                }
                break;
            case "7":
            case "8":
            case "9":
                if (number == 2) {
                    distance = thumb.equals("8") ? 2 : 3;
                } else if (number == 5) {
                    distance = thumb.equals("8") ? 1 : 2;
                } else if (number == 8) {
                    distance = thumb.equals("8") ? 0 : 1;
                } else {
                    distance = thumb.equals("8") ? 1 : 2;
                }
                break;
            case "*":
            case "0":
            case "#":
                if (number == 2) {
                    distance = thumb.equals("0") ? 3 : 4;
                } else if (number == 5) {
                    distance = thumb.equals("0") ? 2 : 3;
                } else if (number == 8) {
                    distance = thumb.equals("0") ? 1 : 2;
                } else {
                    distance = thumb.equals("0") ? 0 : 1;
                }
                break;
        }
        return distance;
    }
}