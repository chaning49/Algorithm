import java.util.*;

class Solution {
    public class Answer {
        String title;
        int time;
        int order;
        
        public Answer(String title, int time, int order) {
            this.title = title;
            this.time = time;
            this.order = order;
        }
        
        public String getTitle() {
            return title;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        // 정답 후보를 저장할 ansList와 순서를 저장할 cnt 선언
        List<Answer> ansList = new ArrayList<>();
        int cnt = 1;
        int maxTime = -1;
        
        // m에서 #을 빼준다.
        String melody = changeMelody(m);
        
        // musicinfos를 여러 방법에 맞춰서 비교해야 한다.
        for (String musicinfo : musicinfos) {
            String[] mInfo = musicinfo.split(",");
            int minutes = makeMinute(mInfo[0], mInfo[1]);
            String title = mInfo[2];
            String infoMelody = changeMelody(mInfo[3]);
            
            // 시간만큼 문자열을 이어붙여준다.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minutes / infoMelody.length(); i++) {
                sb.append(infoMelody);
            }
            sb.append(infoMelody.substring(0, minutes % infoMelody.length()));
            
            // 이어붙인 문자열에서 m이 있다면 정답 목록에 추가
            if (sb.toString().contains(melody)) {
                Answer ans = new Answer(title, minutes, cnt);
                ansList.add(ans);
                maxTime = Math.max(maxTime, minutes);
                cnt++;
            }
        }
        
        if (ansList.size() == 0) {
            answer = "(None)";
        } else if (ansList.size() == 1) {
            answer = ansList.get(0).getTitle();
        } else if (ansList.size() > 1) {
            Collections.sort(ansList, new Comparator<Answer>() {
                @Override
                public int compare(Answer a1, Answer a2) {
                    if (a1.time - a2.time == 0) {
                        return a1.order - a2.order;
                    }
                    return a2.time - a1.time;
                }
            });
            answer = ansList.get(0).getTitle();
        }
        
        return answer;
    }
    
    // 음정에 #이 붙은 친구들을 하나의 문자열로 치환해준다.
    private String changeMelody(String m) {
        return m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
    }
    
    // 시간을 분 단위로 만들어준다.
    private int makeMinute(String startTime, String endTime) {
        int start = calculateTime(startTime);
        int end = calculateTime(endTime);
        
        return end - start;
    }
    
    // HH:MM 형식인 시간을 int 타입으로 변경해서 분 단위로 만들어준다.
    private int calculateTime(String strTime) {
        int hour = Integer.parseInt(strTime.substring(0, 2));
        int min = Integer.parseInt(strTime.substring(3));
        return hour * 60 + min;
    }
}