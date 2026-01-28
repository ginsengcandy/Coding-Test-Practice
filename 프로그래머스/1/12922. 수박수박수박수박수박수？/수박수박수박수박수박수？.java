class Solution {
    public String solution(int n) {
        String answer = "";
        //"수"부터 입력
        String temp = "수";
        //n-1번동안
        for(int i = 1;i<n;i++){
            //이전 입력이 "수"이면 "박"을, 그렇지 않으면 "수"를 입력
            temp = temp.endsWith("수") ? temp.concat("박") : temp.concat("수");
        }
        answer = temp;
        return answer;
    }
}

//오늘 배운 것
/*Java에서 String은 불변 객체이다.
따라서 concat() 메서드는 원본 문자열을 변경하지 않고, 새로운 문자열을 반환한다.
*/