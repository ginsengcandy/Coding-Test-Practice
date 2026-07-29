import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        
        // friends의 모든 원소에 대해 Map 생성
        Map<String, Integer> index = new HashMap<>();
        
        // friends의 각 원소를 인덱스와 1:1 대응
        for(int i = 0; i < n; i++) {
            index.put(friends[i], i);
        }
        
        // 상호 선물 교환 전적을 기록할 2차원 배열 생성
        int[][] transactions = new int[n][n];
        
        // (선물 지수용) 선물 준 횟수 기록
        int[] give = new int[n];
        // (선물 지수용) 선물 받은 횟수 기록
        int[] take = new int[n];
        
        // gifts를 순회하며 각 배열에 기록
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            
            int giverIndex = index.get(split[0]);
            int takerIndex = index.get(split[1]);
            
            transactions[giverIndex][takerIndex]++;
            give[giverIndex]++;
            take[takerIndex]++;
        }
        
        // 선물 지수 계산
        int[] giftScore = new int[n];
        
        for (int i = 0; i < n; i++) {
            giftScore[i] = give[i] - take[i];
        }
        
        // 다음달 받을 선물 개수 기록
        int[] nextMonth = new int[n];
        
        // transactions를 순회하며 선물 받을 횟수 기록
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int iToJ = transactions[i][j];
                int jToI = transactions[j][i];
                
                if (iToJ > jToI) {
                    nextMonth[i]++;
                }
                
                else if (jToI > iToJ) {
                    nextMonth[j]++;
                }
                // 동률인 경우 선물 지수 비교
                else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++;
                    }
                    else if (giftScore[i] < giftScore[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        
        // nextMonth의 최댓값 구하기
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, nextMonth[i]);
        }
        
        return answer;
    }
}