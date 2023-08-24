class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdChulSoo = arrayA[0];
        int gcdYoungHee = arrayB[0];
        
        // 각 배열에서 가능한 최대공약수를 뽑아낸다.
        for (int i = 1; i < arrayA.length; i++) {
            gcdChulSoo = gcd(gcdChulSoo, arrayA[i]);
            gcdYoungHee = gcd(gcdYoungHee, arrayB[i]);
        }
        
        // 철수의 최대 공약수로 배열 B에서 나눠지는 것이 없으면 answer와 비교 후 저장
        if (checkDivision(gcdChulSoo, arrayB)) {
            answer = answer < gcdChulSoo ? gcdChulSoo : answer;
        }
        
        // 영희의 최대 공약수로 배열 A에서 나눠지는 것이 없으면 answer와 비교 후 저장
        if (checkDivision(gcdYoungHee, arrayA)) {
            answer = answer < gcdYoungHee ? gcdYoungHee : answer;
        }
        
        return answer;
    }
    
    // 최대 공약수 구하기
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    
    // 배열을 최대 공약수로 나눌 수 있는지 확인 -> 나눌 수 있으면 false
    private boolean checkDivision(int gcd, int[] arr) {
        for (int a : arr) {
            if (a % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}