import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 공백이 아닌 문자 발견 시 사용할 인덱스
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            // 읽기 전용인 경우, String의 각 문자를 charAt(i)로 접근할 수 있다.
            char c = s.charAt(i);
            // c의 공백/문자 유무에 따라 처리 다르게
            if(c == ' '){
                answer.append(' ');
                // 이전 단어의 index가 끝났으므로 0으로 초기화
                index = 0;
            }
            // 문자인 경우 index 값에 따라 대/소문자 처리
            else{
                if(index % 2 == 0){
                    answer.append(Character.toUpperCase(c));
                } else {
                    // (주의) 조건에서 원본 단어가 전부 소문자라고 하지 않음
                    answer.append(Character.toLowerCase(c));
                }
                // 대/소문자 처리 후 단어 내 다음 문자로 넘어감
                index++;
            }
        }
        return answer.toString();
    }
}

/*
향상된 for문에서 순회자 변수는 배열의 복사본이다.
반면, index 기반 for문은 각 배열 요소의 주소값을 가리킨다.

*/