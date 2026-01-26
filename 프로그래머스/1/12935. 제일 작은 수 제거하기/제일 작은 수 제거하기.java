import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        //빈 배열이거나 원소가 1개이면 리턴 시 빈 배열이므로 -1 채워 리턴
        if(arr.length <= 1){
            answer = new int[]{-1};
            return answer;
        }
        //임시 리스트 생성
        List<Integer> temp = new ArrayList<>();
        //배열에서 최솟값 찾으면서 임시 리스트에 원소 복사
        int min = arr[0];
        for(int number:arr){
            temp.add(number);
            if(number < min)
                min = number;
        }
        //복사한 임시 리스트에서 최솟값 원소 제거
        temp.remove(Integer.valueOf(min));
        //임시 리스트를 다시 배열로 변환한 뒤 answer에 할당
        answer = temp.stream().mapToInt(Integer::intValue).toArray();
        //answer 반환
        return answer;
    }
}