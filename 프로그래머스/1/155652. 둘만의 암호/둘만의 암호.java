import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        // skip의 각 문자를 set에 저장 -> c 와 c+index 사이의 알파벳이 skip에 포함되었는지 빠르게 확인하기 위함
        // 스트림보다는 문자 배열로 변환한 뒤 각 배열의 원소를 추가하는 방식이 오버헤드가 덜함
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        // StringBuilder 생성 -> 문자 개별 변환 뒤 추가
        StringBuilder answerStringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int rotation = rotateWithSkip(s.charAt(i), skipSet, index);
            char charAfterRotation = cyclicShift(s.charAt(i) + rotation);
            answerStringBuilder.append(charAfterRotation);
        }
        // StringBuilder -> String
        answer = answerStringBuilder.toString();
        return answer;
    }
    
    // 문자가 skipSet에 있는 문자들을 제외하고 총 몇 칸을 이동해야 하는지 계산하여 반환하는 메서드
    public int rotateWithSkip(char c, Set<Character> skipSet, int index) {
        int count = 0;
        int rotation = 0;
        
        while(count < index) {
            rotation++;
            char next = cyclicShift(c + rotation);
            if(!skipSet.contains(next)) {
                count++;
            }
        }
        return rotation;
    }
    
    // 숫자를 넣으면 알파벳으로 변환하되, 소문자 범위를 넘어서면 다시 'a'부터 시작하는 변환기
    public char cyclicShift(int c) {
        return (char) ((c-'a') % 26 + 'a');
    }
}
                                
                        

/*
StringBuilder에 문자 추가는 add가 아닌 append
무작정 알파벳을 이동시키면 알파벳 범위를 초과할 수 있음. 모듈러 연산으로 순환 이동(cyclic shift) 구현 필요
문자는 문자고, 숫자는 숫자다. 문자 Set에 숫자를 가지고 있는지 확인하면 당연히 no다. 
*/