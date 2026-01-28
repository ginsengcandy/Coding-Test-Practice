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