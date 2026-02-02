class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        //등차수열의 합
        long debt = (long)price * count * (count+1) / 2 - (long)money; //오버플로우 주의
        if(debt < 0) return answer;
        answer = debt;
        return answer;
    }
}