import java.util.*;
class Solution {
    public long solution(long n) {
        long answer;
        //각 자릿수를 리스트로 변환
        List<String> list = new ArrayList<>();
        while(n > 0){
            list.add(Long.toString(n % 10));
            n /= 10;
        }
        //리스트를 순회하면서 내림차순으로 정렬
        Collections.sort(list,Collections.reverseOrder());
        //리스트를 문자열로 변환
        String s = String.join("",list);
        //문자열을 숫자로 변환
        answer = Long.parseLong(s);

        return answer;
    }
}