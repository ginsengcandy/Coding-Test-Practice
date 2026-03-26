import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        if(m <= score.length) {
            Arrays.sort(score);
            for(int i = score.length-1; i >= m-1; i-=m)
             answer += m * score[i-m+1];
        }
        return answer;
    }
}

/*
정리
score = 각 사과들의 점수 배열, 길이는 최대 100만,배열 내 최댓값은 k로 주어짐
사과는 m개씩 포장, k는 최댓값
사과 한 박스의 가격은 (박스 내 최저가 * m)

3줄 풀이
한 박스의 가격은 최저가 * m
이익은 모든 박스의 가격의 합, 하지만 박스마다 가격이 다름
박스의 개수를 j라고 할 때,
m * (최저가1 + 최저가2 + 최저가3 + ... + 최저가j)의 최대 금액을 구하는 것이 과제
score = {1,2,3,4,3,2,1}, m = 4인 조건이라면
박스는 1개 : 7/4 = 1이므로.
이익을 최대화하는 최저가[1]은 2. 따라서 max = 2*4*1 = 8.
같은 조건에서 m만 3으로 바뀐다면
박스는 2개 : 7/3 = 2이므로
최저가는 1,2,3이 가능: 3보다 크거나 같은 수가 3개.
최저가가 3인 박스를 먼저 포장하면 남은 배열은 {1,2,2,1}이며, 이제 2보다 크거나 같은 수는 2개가 되어 최저가는 1만 가능함. 따라서 가격은 3 * (1 + 3) = 12

풀이방법 정리
m <= score.length인지 검사 -> 참이면 루프 진입, 거짓이면 return 0;
loop{
주어진 score 배열을 정렬(예: 내림차순). {4,3,3,2,2,1,1}
(m번째 원소 * m)를 계산하여 첫번째 박스의 가격을 구한 뒤, answer에 누적: answer += m*score[m-1];
(m+m번째 원소 *m)를 계산하여 두번째 박스의 가격을 구한 뒤, answer에 누적: answer += m*score[2m-1]
.
.
(m * score.length/m 번째 원소)를 계산하여 score.length/m번째 박스의 가격을 구한 뒤, answer에 누적: answer += m * score[m * score.length/m -1]
}
return answer;

그런데 Arrays.sort는 오름차순밖에 안 됨.
내림차순으로 하려면 래퍼 클래스로 바꿔야 함.
그럴바엔 오름차순으로 해서 맨 마지막 요소부터 루프를 출발하는 게 나음
*/
