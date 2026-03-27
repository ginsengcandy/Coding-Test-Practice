import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        // initialization
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        // counting right answers
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == getNum(i, arr1)) count1++;
            if(answers[i] == getNum(i, arr2)) count2++;
            if(answers[i] == getNum(i, arr3)) count3++;
        }
        
        // ranking
        int[] scores = {count1, count2, count3};
        return getRank(scores);
        
    }
    
    // 각 배열의 index 위치에 있는 요소를 반환하는 헬퍼 함수
    private int getNum(int idx, int[] array) {
        return array[idx % array.length];
    }
    
    // get the list of indexes of the biggest elements in the given array
    private int[] getRank(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] == max)
                result.add(i+1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
문제 개수는 10,000개 이내
1번: 12345
2번: 21232425
3번: 3311224455
문제가 n개(1 <= n <= 10000) 있을 때, 각 수포자의 k번째(1 <= k <= n) 답을 일반화하면
1번: k % 5 + 1
2번:
int[] arr2 = {2,1,2,3,2,4,2,5} 배열에서 arr2[(k-1) % arr2.length];
3번: int[] arr3 = {3,3,1,1,2,2,4,4,5,5} 배열에서 arr3[(k-1) % arr3.length]
1번도 마찬가지로 일반화 가능
*/
