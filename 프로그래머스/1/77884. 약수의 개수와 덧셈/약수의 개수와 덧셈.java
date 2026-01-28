import java.util.stream.IntStream;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        //약수의 개수를 구하는 함수 countAll
        answer = IntStream.rangeClosed(left,right) //left부터 right까지
            // .filter(n -> countAll(n) % 2 == 0) //약수의 개수가 짝수인 것만
            .map(n -> countAll(n) % 2 == 0? n : -n)//짝수인 것은 그냥 두고, 홀수인 것만 음수로 변환한다.
            .sum(); //더한다
        return answer;
    }
    
    public int countAll(int number){
        int count = 0;
        for(int i = 1;i<=number;i++){
            if(number % i == 0) count++;
        }
        return count;
    }
}
//오늘 배운 것
/*문제는 완벽하게 이해했더라도 예시까지 자세히 보도록 하자.
홀수인 수를 뺀다는 것은 제외한다는 의미일 수도 있지만, 마이너스(-)의 의미도 있을 수 있다.
*/


