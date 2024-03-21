import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int one = 0;
    static int two = 0;
    static int oneSum = 0;
    static int twoSum = 0;
    static String prev, team, sec;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            team = st.nextToken(); // 팀 번호
            sec = st.nextToken(); // 시간
            
            // 점수가 더 높은 팀이 생기면 현재 시간 기준으로 이전 시간과 비교하여 계산
            if (one > two) calcOne(sec);
            else if (two > one) calcTwo(sec);
            
            // 득점한 팀 번호 증가
            if (team.equals("1")) one++;
            else two++;
            
            // 이전 시간 저장
            prev = sec;
        }
        // 경기 종료 시간까지 이기고 있는 팀 시간 계산
        if (one > two) calcOne("48:00");
        else if (two > one) calcTwo("48:00");
        
        System.out.println(printTime(oneSum));
        System.out.println(printTime(twoSum));
    }
    
    // 이기고 있는 팀의 점수 계산
    public static void calcOne(String sec) {
        oneSum += (changeToSec(sec) - changeToSec(prev));
    }

    public static void calcTwo(String sec) {
        twoSum += (changeToSec(sec) - changeToSec(prev));
    }
    
    // "01:30" 형태의 문자열을 90과 같은 초 단위로 변경 
    private static int changeToSec(String sec) {
        String[] input = sec.split(":");
        return Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
    }
    
    // 90과 같은 초 단위를 "01:30" 같은 문자열로 변경
    public static String printTime(int sum) {
        return appendTime(sum / 60) + ":" + appendTime(sum % 60);
    }
    
    // 시간의 자릿수 계산
    private static StringBuilder appendTime(int time) {
        return (time >= 10) ? new StringBuilder().append(time) : new StringBuilder().append("0").append(time);
    }
}