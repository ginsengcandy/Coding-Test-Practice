class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = (long)num;
        while(number!=1){
            if(number%2==0){
                number /= 2;
                answer++;
                if(answer>=500){
                    answer = -1;
                    break;
                }
                continue;
            }
            number = number*3+1; //오버플로우 가능성?
            answer++;
            if(answer>=500){
                answer = -1;
                break;
            }
            continue;
        }
        return answer;
    }
}