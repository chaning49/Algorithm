class Solution {
    public int[] solution(String s) {
        int[] ans = new int[2];
        
        // s가 1 하나만 남기 전까지 반복
        while (!s.equals("1")) {
            // s에서 0의 개수를 count
            for (String str : s.split("")) {
                if (str.equals("0"))
                    ans[1]++;
            }
            // s에서 0을 제거한다.
            s = s.replace("0", "");
            // s의 길이를 이진수로 바꾼다.
            s = Integer.toBinaryString(s.length());
            // 이진 변환의 횟수 증가
            ans[0]++;
        }
        
        return ans;
    }
}