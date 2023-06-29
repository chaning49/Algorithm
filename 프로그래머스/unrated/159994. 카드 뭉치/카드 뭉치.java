class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        // card의 인덱스를 각각 저장
        int idx1 = 0;
        int idx2 = 0;
        
        // goal을 하나씩 순회하면서 같은 알파벳이 나오면 제거 후 인덱스 증가
        // 만들 수 없는 알파벳이 나오면 return No
        for (String g : goal) {
            if (idx1 < cards1.length && cards1[idx1].equals(g)) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(g)) {
                idx2++;
            } else {
                return "No";
            }
        }
        
        return answer;
    }
}