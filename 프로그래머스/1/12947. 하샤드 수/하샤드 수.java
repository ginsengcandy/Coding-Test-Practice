class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = x;
        int aggsum = 0;
        while(num > 0){
            aggsum += num % 10;
            num /= 10;
        }
        if (x % aggsum != 0){
            return false;   
        }
        return answer;
    }
}