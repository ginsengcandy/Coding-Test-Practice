import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        //0부터 10까지 모두 존재하는 리스트 생성
        List<Integer> ideal = new ArrayList();
        for(int i = 0;i<10;i++) ideal.add(i);
        //원본 배열을 순회하며 원본에 있는 원소는 리스트에서 제거
        for(int num:numbers){
            for(int c:ideal){
                if(num == c) {
                    ideal.remove(Integer.valueOf(num));
                    break;
                } 
            }
        }
        //리스트에서 남아있는 숫자만 answer에 누적하기
        for(int c:ideal) answer+=c;
        return answer;
    }
}