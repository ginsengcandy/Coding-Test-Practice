class Solution {
    public String solution(String X, String Y) {
        // 0으로 초기화
        int[] countX = new int[10]; 
        int[] countY = new int[10];
        
        // 각 문자열의 자릿수를 순회하며 숫자별 빈도를 카운팅하여 배열에 업데이트
        // 각 배열의 인덱스는 0부터 9까지의 자릿수를 의미하며, 배열의 값은 빈도 수를 의미
        count(X, countX);
        count(Y, countY);
        
        // 배열을 뒤에서부터 순회하며 더 작은 값을 선택하여 새로운 문자열 생성
        // StringBuilder 사용하여 메모리 공간 절약
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            long min = Math.min(countX[i], countY[i]);
            for(int j = 0; j < min; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
    
    private void count(String s, int[] arr) {
        for(int i = 0; i < s.length(); i++) {
            arr[Character.getNumericValue(s.charAt(i))]++;
        }
    }
}
/*
어제 간과했던 부분
1. x,y의 자릿수 : 최소 3에서 최대 3백만
2. x,y는 문자열 형태의 양의 정수

새롭게 알게 된 것
1. string.charAt(i) 메서드를 사용하면 메모리를 추가로 할당할 필요가 없다. 단순 조회 용도라면 toCharArray() 대신 charAt(i)를 사용하자. 
*/