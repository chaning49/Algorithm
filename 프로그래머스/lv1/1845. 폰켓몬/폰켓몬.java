import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // nums의 개수 / 2를 변수에 저장
        int count = nums.length / 2;
        
        // nums를 Set에 저장
        Set<Integer> numSet = new HashSet<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        
        answer = numSet.size() >= count ? count : numSet.size();
        return answer;
    }
}