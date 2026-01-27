class Solution {
    public String solution(String s) {
        String answer = "";
        //문자열의 길이가 1인지 짝수인지 홀수인지 판단
        boolean even = (s.length() % 2 == 0);
        int halfIndex = s.length() / 2;
        //1이면 문자열 그대로 반환
        if(halfIndex == 0) return s;
        //짝수이면 왼쪽에서 길이/2번째, 길이/2+1번째 글자를 반환
        if(even) {
            answer = s.substring(halfIndex-1, halfIndex+1);
        }
        //홀수이면 왼쪽에서 길이/2+1번째 글자를 반환
        else
            answer = s.substring(halfIndex,halfIndex+1);
        return answer;
    }
}