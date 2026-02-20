import java.math.BigInteger;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        final int iteration = t.length() - p.length() + 1;

        for(int i = 0;i < iteration; i++){
            String tsub = t.substring(i, i+p.length());
            
            BigInteger tBigInt = new BigInteger(tsub);
            BigInteger pBigInt = new BigInteger(p);
            
            int isBigger = tBigInt.compareTo(pBigInt);
            
            if(isBigger < 1) {
                answer++;
            } 
        }
        return answer;
    }
}

/*
시간복잡도: O(n): t의 길이만큼 순회하므로
length(t) = 5
length(p) = 3
5-3+1만큼 순회(3회)
t = "20139"
p = "101"
201 013 139
101 101 101
숫자열 간 크기 비교 2가지 -> parseInt(숫자로 변환), BigInteger.compareTo(숫자가 클 때)
p의 길이가 최대 18(10의 17승)이므로 BigInteger로 변환한 뒤 비교하는 것이 바람직.
p의 길이만큼 t의 문자열을 읽는 것이 중요 -> 문자열 자르기 substring(시작 포함, 끝 인덱스 불포함)
시작을 i라고 하면 끝은 i+p
(t-p+1)만큼 반복
*/