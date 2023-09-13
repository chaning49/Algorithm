import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 소문자로 통일
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // str1과 str2를 두 글자씩 끊어서 각각 저장, 공백, 특수문자 제거
        List<String> listOne = stringToList(str1);
        List<String> listTwo = stringToList(str2);
        
        // str1과 str2의 다중집합을 가지고 교집합과 합집합의 개수를 구한다.
        int gyo = intersection(listOne, listTwo);
        int hap = union(listOne, listTwo);
        
        if (hap == 0) {
            return 65536;
        }
        
        double answer = (double) gyo / hap;
        return (int) (answer * 65536);
    }
    
    // string을 두 글자씩 잘라서 리스트에 저장
    private List<String> stringToList(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                list.add(Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + 1)));
            }
        }
        return list;
    }
    
    // 교집합의 개수 구하기
    private int intersection(List<String> list1, List<String> list2) {
        int cnt = 0;
        List<String> copyList2 = new ArrayList<>(list2);
        for (String s : list1) {
            if (copyList2.contains(s)) {
                cnt++;
                copyList2.remove(s);
            }
        }
        return cnt;
    }
    
    // 합집합의 개수 구하기
    private int union(List<String> list1, List<String> list2) {
        int common = intersection(new ArrayList<>(list1), new ArrayList<>(list2));
        return list1.size() + list2.size() - common;
    }
}