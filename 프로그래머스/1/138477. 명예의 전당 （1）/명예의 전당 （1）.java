import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        list.add(score[0]);
        // 실수 1: 고정 길이의 배열 선언을 잘못함
        int[] answer = new int[score.length];
        int min = score[0];
        answer[0] = min;
        // 실수 5 해답: k 또는 score.length 중 더 작은 값만큼 아래 루프를 반복해야 함.
        for(int i = 1; i < Math.min(k, score.length); i++) {
            // 실수 2. 최솟값이 갱신되지 않아 계속 동일한 값으로 비교함
            // 실수 5. 여기에도 k > score.length인 경우에 대한 방어 코드 누락
            min = Math.min(min, score[i]);
            answer[i] = min;
            list.add(score[i]);
        }
        // 실수 3. k가 score.length보다 큰 경우 방어 코드 필요
        if(k <= score.length) {
            for(int i = k; i < score.length; i++) {
                list.add(score[i]); // 엔트리 추가
                // 실수 4. 내림차순으로 정렬해야 하는데 오름차순(기본값)으로 정렬함
                Collections.sort(list, Collections.reverseOrder());
                answer[i] = list.get(k-1); // 0-based index이므로 k번째는 (k-1) 위치에
            }
        }
        
        return answer;
    }
}

/*
k일차까지는 새 엔트리가 들어올 때마다 최소값을 구하고,
k+1일차부터는 k번째 값을 구해야 한다.
새 엔트리가 들어올 때마다 k번째 값은 달라져야 하므로, 매번 정렬이 일어나야 한다.
퀵 정렬인 Arrays.sort()나 Collections.sort()가 유리하다.
요소의 삽입과 삭제가 빈번하게 일어나므로 ArrayList를 활용한 Collections.sort()를 이용하자.
*/