class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        while (i < s.length()) {
            char x = s.charAt(i);
            int xCount = 0, elseCount = 0;
            while (i < s.length()) {
                if (s.charAt(i) == x) xCount++;
                else elseCount++;
                i++;
                if (xCount == elseCount) break; // 같아지면 분리
            }
            answer++;  // 루프가 break로 끝나든, 글자 소진으로 끝나든 무조건 +1
        }
        return answer;
    }
}
/*
처음으로 두 횟수가 같아지거나, 더 이상 읽을 글자가 없다면 종료

*/