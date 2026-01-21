import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(Integer num:arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
        if(list.isEmpty()) list.add(-1);
        Collections.sort(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}