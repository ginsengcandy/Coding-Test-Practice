class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i]/2; j++) {
                sb.append(i);
            }
        }
        String half = sb.toString();
        return half + "0" + sb.reverse();
    }
}

/*
i부터 읽어나가자. i = 1
i번 음식은 한쪽에 food[i]/2번씩 기록 후 i++
i >= food.length이면 종료 후 지금까지 기록한 사항을 반전시킨 결과 만들기
사이에 0을 넣은 뒤 최종 문자열 반환
*/

/*
StringBuilder.reverse()는 원본 자체를 바꿔버린다.
*/