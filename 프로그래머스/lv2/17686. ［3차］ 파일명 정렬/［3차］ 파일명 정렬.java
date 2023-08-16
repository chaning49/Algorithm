import java.util.*;
import java.util.stream.Collectors;

// 리팩토링 코드
class Solution {
    public static class File {
        private String head;
        private int number;
        private String tail;
        private int index;
        
        public File(String head, int number, String tail, int index) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }
        
        private String getHead() {
            return this.head;
        }
        
        private int getNumber() {
            return this.number;
        }
        
        public int getIndex() {
            return this.index;
        }
    }
    
    public String[] solution(String[] files) {
        List<File> divisionFiles = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            divisionFiles.add(makeDivisionFile(files[i], i));
        }
        
        // head와 number 순서대로 정렬 후 index 순으로 정렬하면 원래의 입력순서까지 체크해줄 수 있다.
        divisionFiles.sort(Comparator.comparing(File::getHead)
                                      .thenComparing(File::getNumber)
                                      .thenComparing(File::getIndex));
        
        return divisionFiles.stream()
                            .map(file -> files[file.getIndex()])
                            .toArray(String[]::new);
    }
    
    private File makeDivisionFile(String file, int i) {
        // 소문자로 문자열 한 번에 변경
        String lowerFile = file.toLowerCase();
        
        // head의 인덱스 저장
        int headEnd = 0;
        while (headEnd < file.length() && !Character.isDigit(lowerFile.charAt(headEnd))) {
            headEnd++;
        }
        
        // number의 인덱스 저장
        int numberEnd = headEnd;
        while (numberEnd < file.length() && Character.isDigit(lowerFile.charAt(numberEnd)) && numberEnd - headEnd < 5) {
            numberEnd++;
        }

        String head = lowerFile.substring(0, headEnd);
        int number = Integer.parseInt(file.substring(headEnd, numberEnd));
        String tail = file.substring(numberEnd);

        return new File(head, number, tail, i);
    }
}