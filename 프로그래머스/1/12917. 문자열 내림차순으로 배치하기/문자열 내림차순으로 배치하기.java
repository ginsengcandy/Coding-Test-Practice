import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        //문자열을 리스트로 변환
        String[] strArr = s.split("");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));
        //리스트를 정렬
        Collections.sort(list, Collections.reverseOrder());
        //리스트를 다시 문자열로 변환
        answer = String.join("", list);
        //문자열을 반환
        return answer;
    }
}

//배운 점
/*
new ArrayList<>()의 <> 안에는 굳이 자료형을 넣지 않아도 된다.
문자열을 리스트로 바로 바꿀 수는 없고, 배열을 한번 거쳐야 한다. Arrays.asList(배열)은 리스트를 반환한다.
리스트를 다시 문자열로 반환할 때는 String.join(delimiter, elements)을 사용한다. 이는 delimiter로 구분된 String을 반환한다. 구분자 없이 이어진 문자열로 붙이고 싶을 경우 delimiter에 공백("")을 대입하면 된다.
*/