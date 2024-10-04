class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    private void dfs(int[] nums, int depth, int target, int sum) {
        if (depth == nums.length) {
            if (sum == target) {
                answer++;
            }
        }
            
        else {
            dfs(nums, depth + 1, target, sum + nums[depth]);
            dfs(nums, depth + 1, target, sum - nums[depth]);
        }
    }
}