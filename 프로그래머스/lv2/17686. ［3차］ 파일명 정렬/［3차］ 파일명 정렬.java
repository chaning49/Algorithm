import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public class File {
        private String head;
        private int number;
        private String tail;
        private int index;
        
        public File(String head, int number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public File() {
            this.head = "";
            this.number = 0;
            this.tail = "";
            this.index = 0;
        }
        
        private String getHead() {
            return this.head;
        }
        
        private int getNumber() {
            return this.number;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> divisionFiles = new ArrayList<>(files.length);
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            divisionFiles.add(makeDivisionFile(file.toLowerCase(), i));
        }
        
        // head와 number 순서대로 정렬
        List<File> answerFiles = divisionFiles.stream()
            .sorted(Comparator.comparing(File::getHead)
                   .thenComparing(File::getNumber))
            .collect(Collectors.toList());
        
        for (int i = 0; i < files.length; i++) {
            int idx = answerFiles.get(i).index;
            answer[i] = files[idx];
        }
        
        return answer;
    }
    
    private File makeDivisionFile(String file, int i) {
        File f = new File();
        
        int idx = 0;
        String num = "";
        boolean isNumPart = false;
        
        for (char c : file.toCharArray()) {
            // 숫자이고 num의 길이가 5 미만이면 num에 합쳐주기
            if (Character.isDigit(c)) {
                if (num.length() < 5) {
                    num += c;
                }
                isNumPart = true;
            } else {
                if (!isNumPart) {
                    f.head += c;
                } else {
                    f.number = Integer.parseInt(num);
                    f.tail = file.substring(idx);
                    f.index = i;
                    break;
                }
            }
            idx++;
        }
        
        // 숫자 파트 후에 문자가 없는 경우 (tail이 없는 경우)
        if (f.tail.isEmpty() && !num.isEmpty()) {
            f.number = Integer.parseInt(num);
            f.index = i;
        }

        // head 부분을 대소문자 구분 없이 정렬하기 위해
        f.head = f.head.toLowerCase();
        
        return f;
    }
}