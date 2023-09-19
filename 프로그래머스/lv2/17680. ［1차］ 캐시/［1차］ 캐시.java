import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // cacheSize가 0인 경우, cities의 크기 x 5
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        // cache를 저장할 List 생성
        List<String> cache = new ArrayList<>();
        
        // cache 사이즈를 체크하면서 cities 순회
        for (String city : cities) {
            String name = city.toLowerCase();
            
            if (cache.size() < cacheSize) {
                if (cache.contains(name)) {
                    cache.remove(name);
                    cache.add(name);
                    answer += 1;
                    continue;
                }
                cache.add(name);
                answer += 5;
            } else if (cache.size() == cacheSize) {
                if (cache.contains(name)) {
                    cache.remove(name);
                    cache.add(name);
                    answer += 1;
                } else if (!cache.isEmpty() && !cache.contains(name)) {
                    cache.remove(0);
                    cache.add(name);
                    answer += 5;
                }
            } 
        }
        
        return answer;
    }
}