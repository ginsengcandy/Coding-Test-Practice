class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length -1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(isPrime(nums[i], nums[j], nums[k]))
                        answer++;
                }
            }
        }
        return answer;
    }
    
    private boolean isPrime(int a, int b, int c) {
        int sum = a + b + c;
        if(sum % 2 == 0) return false;
        for(int i = 3; i <= sum / 2; i++)
            if(sum % i == 0) return false;
        return true;
    }
}
// 3000 이하의 소수의 개수는 450개..하드코딩하기엔 너무 많다.
// 50개에서 중복을 허용하지 않고 3개를 고르는 경우의 수는 50*49*8 -> 모든 원소를 순회하면 n제곱 복잡도
// 3개의 수를 더했을 때 짝수이면, 반드시 홀수가 아니다.