import java.util.*;
import java.io.*;

public class Main {
    static List<String> numList = new ArrayList<>();;
    static String str;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c)) sb.append(c);
                else if (sb.length() > 0) {
                    go();
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) go();
        }
        
        // sort
        numList.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        
        for (String num : numList) {
            System.out.println(num);
        }
    }
    
    public static void go() {
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        if (sb.length() == start) numList.add("0");
        else numList.add(sb.substring(start));
    }
}