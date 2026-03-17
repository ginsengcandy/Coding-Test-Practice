class Solution {
    public int solution(int a, int b, int n) {
        int totalBottles = 0;
        int quotient;
        while(n / a > 0) {
            quotient = n / a;
            totalBottles += b * quotient;
            n = n - quotient * (a-b);
        }
        
        return totalBottles;
    }
}
/*
a개를 가져다주면 b병을 준다
n = 최초의 병 개수의 합
1회 시행 이후 남은 병 개수의 합 = m = n - a + b
굳이 a씩 뺄 필요가 없다(예: a = 2, n = 20, b = 1인 경우, 1회 시행 시 20 - 2*10 + 10 = 10개.
10 = n / a (단, 0보다 커야 한다. 예를 들어 n = 2, a = 3인 경우 실행 불가)
10 = b * (n / a)
위와 같이 1회 시행하고 나면 n = n - a + b
n이 a보다 작으면 종료
*/