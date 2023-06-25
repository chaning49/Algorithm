import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 앞에서부터 비교하기 위해 sort
        Arrays.sort(phone_book);
        
        // for문을 순회하면서 접두어와 같은 부분을 특수문자로 바꾸기
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
    }
}