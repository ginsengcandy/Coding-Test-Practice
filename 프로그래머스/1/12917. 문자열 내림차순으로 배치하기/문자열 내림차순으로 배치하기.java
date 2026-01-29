import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        //문자열을 리스트로 변환
        String[] strArr = s.split("");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArr));
        //리스트를 정렬
        Collections.sort(list, Collections.reverseOrder());
        //리스트를 다시 문자열로 변환
        answer = String.join("", list);
        //문자열을 반환
        return answer;
    }
}