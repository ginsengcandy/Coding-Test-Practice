import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) { // e.g. s = "banana"
        List<Integer> answerList = new ArrayList<>();
        answerList.add(-1);
        
        if(s.length() > 1) {
            for(int i = 1; i < s.length(); i++) {
                answerList.add(-1);
                
                for(int j = 1; j <= i; j++) {
                    if(s.charAt(i) == (s.charAt(i - j))) {
                        answerList.remove(i);
                        answerList.add(j);
                        break;
                    }
                }
    
            }
        }
        
        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

// 3줄 접근
/*
초기화: 정수 리스트를 만들고, -1을 넣는다.
문자 길이가 2 이상이면 문자들을 2번째자리부터 읽어가며 알고리즘을 실행한다.
정수 리스트를 배열로 변환하여 반환한다.
*/