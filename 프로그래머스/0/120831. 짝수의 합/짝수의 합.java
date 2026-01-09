class Solution {
    public int solution(int n) {
        int answer = 0;
        if(0< n && n <= 1000){
            if(n==1) return 0;
            if(n>=2){
                if(n%2==0){
                    return n+solution(n-2);
                }
                return solution(n-1);
            }
        }
        return answer;
    }
}