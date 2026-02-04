class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        int max; //최대공약수
        int min; //최소공배수
        max = getMax(n,m);
        min = getMin(n,m);
        answer = new int[] {max,min};
        return answer;
    }
    private int getMax(int n, int m){
        int gcd=1;
        for(int i = 2;i<=Math.min(n,m);i++){
            if(n % i == 0 && m % i == 0)
                gcd = i;
        }
        return gcd;
    }
    private int getMin(int n, int m){
        return n * m / getMax(n,m); //두 수의 곱 = 최대공약수 * 최소공배수
    }
}