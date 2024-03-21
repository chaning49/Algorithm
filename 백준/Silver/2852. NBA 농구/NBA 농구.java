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
            team = st.nextToken();
            sec = st.nextToken();

            if (one > two) calcOne(sec);
            else if (two > one) calcTwo(sec);

            if (team.equals("1")) one++;
            else two++;

            prev = sec;
        }
        if (one > two) calcOne("48:00");
        else if (two > one) calcTwo("48:00");
        System.out.println(printTime(oneSum));
        System.out.println(printTime(twoSum));
    }

    public static void calcOne(String sec) {
        oneSum += (changeToSec(sec) - changeToSec(prev));
    }

    public static void calcTwo(String sec) {
        twoSum += (changeToSec(sec) - changeToSec(prev));
    }

    public static int changeToSec(String sec) {
        String[] input = sec.split(":");
        return Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
    }

    public static String printTime(int sum) {
        return appendTime(sum / 60) + ":" + appendTime(sum % 60);
    }

    public static StringBuilder appendTime(int time) {
        return (time >= 10) ? new StringBuilder().append(time) : new StringBuilder().append("0").append(time);
    }
}