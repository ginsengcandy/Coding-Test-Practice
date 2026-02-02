class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        //길이가 4 또는 6인지
        if(s.length()==4 || s.length()==6){
            //모든 자리가 숫자인지
            for(int i = 0;i< s.length();i++){
                char each = s.charAt(i);
                //ascii 코드값 0부터 9까지 : 48부터 57 사이
                if(each < 48 || each > 57) return false;
            }
            answer = true;
        }
        return answer;
    }
}
//오늘의 배움
/*문자열의 길이는 .length()로 구하고, 배열의 길이는 괄호가 없는 .length로 구한다.
ascii 코드값 - 대소문자, 숫자는 익히는 것이 좋다
*/