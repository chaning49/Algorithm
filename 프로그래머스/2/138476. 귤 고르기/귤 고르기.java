import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key : map.keySet()){
            pq.add(map.get(key));
        }

        int cnt = 0, sum = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();

            if(sum < k){
                sum += cur;
                cnt++;
            }

            if(sum >= k){
                break;
            }
        }

        return cnt;
    }
}