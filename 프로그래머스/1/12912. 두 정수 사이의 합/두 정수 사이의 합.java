class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b) {
            answer = (long)a;
            return answer;
        }
        if(a < b) {
            while(a<=b) answer += (long)a++;
            return answer;
        }
        if(a > b) {
            while(b<=a) answer += (long)b++;
            return answer;
        }
        return answer;
    }
}