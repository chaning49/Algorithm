import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> ansMap = new HashMap<>();
        
        // 차량번호에 맞는 총 시간을 구한다.
        for (String r : records) {
            String[] temp = r.split(" ");
            int hour = Integer.parseInt(temp[0].substring(0,2));
            int min = Integer.parseInt(temp[0].substring(3));
            int carNumber = Integer.parseInt(temp[1]);
            
            int time = hour * 60 + min;
            
            if (temp[2].equals("IN")) {
                map.put(carNumber, time);
            }
            
            if (temp[2].equals("OUT")) {
                int inTime = map.get(carNumber);
                if (ansMap.get(carNumber) == null) {
                    ansMap.put(carNumber, time - inTime);
                } else {
                    ansMap.put(carNumber, ansMap.get(carNumber) + (time - inTime));
                }
                map.remove(carNumber);
            }
        }
        
        // 입차 후 출차하지 않은 차량은 23:59분까지 이용한 것으로 간주한다.
        if (!map.isEmpty()) {
            int day = 60 * 23 + 59;
            for (Integer key : map.keySet()) {
                int time = map.get(key);
                if (ansMap.get(key) == null) {
                    ansMap.put(key, day - time);
                } else {
                    ansMap.put(key, ansMap.get(key) + (day - time));
                }
            }
        }
        
        // 차량번호 순으로 정렬
        Map<Integer, Integer> sortedMap = new TreeMap<>(ansMap);
        
        // 비용 계산
        answer = new int[sortedMap.size()];
        int idx = 0;
        for (Integer key : sortedMap.keySet()) {
            int fee = fees[1];
            fee += sortedMap.get(key) <= fees[0] ? 0 : Math.ceil((double)(sortedMap.get(key) - fees[0]) / fees[2]) * fees[3];
            answer[idx++] = fee;
        }
        
        return answer;
    }
}