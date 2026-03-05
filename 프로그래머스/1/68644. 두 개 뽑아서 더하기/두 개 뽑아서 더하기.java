import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> intSet = new TreeSet<>();
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                intSet.add(numbers[i] + numbers[j]);
            }
        }
        
        return intSet.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
// 3줄 접근
/*
서로 다른 인덱스에 있는 모든 두 수를 더하고, 순서를 보장해 주는 Treeset에 더한다.
set에 담긴 요소들을 배열에 복사한다.
배열을 출력한다.
*/