import java.util.*;

public class Main {
    private static List<String> colors;
    public static void main(String[] args) {
        // 색깔 저장을 위한 메모리 할당 및 메서드 실행
        colors = new ArrayList<>(10);
        addColors();

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long number = 0;

        // 입력된 문자열 중 1, 2번은 값을 이어붙여주고, 3번은 10의 거듭제곱 형태로 변경해서 Long 타입으로 변경
        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();
            if (i < 2) {
                sb.append(colors.indexOf(input));
            } else {
                number = (long) Math.pow(10, colors.indexOf(input));
            }
        }
        
        // 결과값 생성
        long answer = Long.parseLong(sb.toString()) * number;

        System.out.println(answer);
        sc.close();
    }
    
    // 색깔 저장 노가다 코드
    private static void addColors() {
        colors.add("black");
        colors.add("brown");
        colors.add("red");
        colors.add("orange");
        colors.add("yellow");
        colors.add("green");
        colors.add("blue");
        colors.add("violet");
        colors.add("grey");
        colors.add("white");
    }
}