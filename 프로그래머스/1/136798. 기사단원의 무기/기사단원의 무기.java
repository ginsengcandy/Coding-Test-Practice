class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += divisorCounterWithLimit(i, limit, power);
        }
        return answer;
    }
    
    private int divisorCounterWithLimit(int number, int limit, int power) {
        if(number == 1) return 1;
        int count = 2;
        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                count++;
            }
            if(count > limit) return power;
        }
        
        return count;
    }
}