import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르별 총 플레이 수
        Map<String, Integer> genresMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!genresMap.containsKey(genres[i])) {
                genresMap.put(genres[i], plays[i]);
            } else {
                genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
            }
        }
        
        // 플레이 수를 기준으로 장르를 내림차순 정렬
        List<String> genresList = new ArrayList<>(genresMap.keySet());
        Collections.sort(genresList, (a, b) -> (genresMap.get(b).compareTo(genresMap.get(a))));
        
        // 플레이 수의 인덱스를 저장
        List<Integer> playsIndex = new ArrayList<>();
        
        // 정렬된 장르를 기준으로 같은 장르에 해당하는 인덱스와 plays 값을 저장
        for (String genre : genresList) {
            Map<Integer, Integer> playsMap = new HashMap<>();
            for (int i = 0; i < plays.length; i++) {
                if (genre.equals(genres[i])) {
                    playsMap.put(i, plays[i]);
                }
            }
            
            // 플레이 수 순서대로 내림차순 정렬(들어가는 값은 인덱스)
            List<Integer> playsList = new ArrayList<>(playsMap.keySet());
            Collections.sort(playsList, (a, b) -> (playsMap.get(b).compareTo(playsMap.get(a))));
            
            // 순차적으로 두 개의 인덱스만 저장
            playsIndex.add(playsList.get(0));
            if (playsList.size() > 1) {
                playsIndex.add(playsList.get(1));
            }
        }
        
        // 배열 형태로 저장
        answer = new int[playsIndex.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = playsIndex.get(i);
        }
        
        return answer;
    }
}