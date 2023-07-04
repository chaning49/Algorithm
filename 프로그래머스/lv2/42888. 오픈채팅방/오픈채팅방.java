import java.util.*;

class Solution {
    private static String USER_ENTER = "님이 들어왔습니다.";
    private static String USER_LEAVE = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        String[] answer;
        List<String> ansList = new ArrayList<>();
        
        // map을 선언해서 user 정보 저장
        Map<String, String> users = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            switch (temp[0]) {
                case "Enter":
                    ansList.add(temp[0] + " " + temp[1]);
                    users.put(temp[1], temp[2]);
                    break;
                case "Change":
                    users.put(temp[1], temp[2]);
                    break;
                case "Leave":
                    ansList.add(temp[0] + " " + temp[1]);
                    break;
                default:
                    break;
            }
        }
        
        // Enter와 Leave만 저장된 ansList의 크기만큼 배열 메모리 할당
        answer = new String[ansList.size()];
        
        // Enter와 Leave가 붙은 상태에서 uid를 닉네임으로 변경해서 하나씩 붙여준다.
        for (int i = 0; i < answer.length; i++) {
            String[] strArr = ansList.get(i).split(" ");
            if (strArr[0].equals("Enter")) {
                answer[i] = users.get(strArr[1]) + USER_ENTER;
            } else if (strArr[0].equals("Leave")) {
                answer[i] = users.get(strArr[1]) + USER_LEAVE;
            }
        }
        
        return answer;
    }
}