class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        //어느 한 배열의 길이만큼(a.length) 반복하여
        for(int i = 0;i<a.length;i++){
            //1부터 n번째 인덱스 간의 곱을 누적한다
            answer += a[i] * b[i];
        }
     
        return answer;
    }
}
//오늘 배운 것
/*배열은 문자열과 달리 가변 객체이나, 그 길이가 불변이다.
따라서 원소뿐만 아니라 길이까지 변경이 필요한 경우엔 리스트를 사용한다.*/