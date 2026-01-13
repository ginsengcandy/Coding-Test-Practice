class Solution {
    public int solution(int n) {
        int answer = 0;
        if(!((3 <= n) && (n <= 1000000))){
            return answer;
        }
        int i = 3;
        while(i <= n){
            //n이 홀수이면 x는 무조건 2
            if(n % 2 == 1) return 2;
            //n이 짝수일 경우
            if(n % i == 1) return i;
            i++;
        }
        answer = i;
        return answer;
    }
}