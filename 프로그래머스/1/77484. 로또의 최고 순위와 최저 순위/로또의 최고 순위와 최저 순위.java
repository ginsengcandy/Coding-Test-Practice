class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int lowest = getRank(countAnswers(lottos, winNums));
        int highest = getRank(countAnswers(lottos, winNums) + countZeros(lottos));
        return new int[] {highest, lowest};
    }
    
    private int countZeros(int[] lottos) {
        int count = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0)
                count++;
        }
        
        return count;
    }
    
    private int countAnswers(int[] lottos, int[] winNums) {
        int count = 0;
        for(int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                continue;
            for (int j = 0; j < winNums.length; j++) {
                if (lottos[i] == winNums[j])
                    count++;
            }
        }
        return count;
    }
    
    private int getRank(int numOfAnswers) {
        switch (numOfAnswers) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
// 배열에서 0의 개수를 알려주는 함수(getZeros(int[] lottos))
// 정답 개수에 따라 등수를 알려주는 함수(getRank(int numOfAnswers)
// 정답 배열을 기준으로 정답 개수를 계산해주는 함수(countAnswers(int[] lottos, int[] winNums))
/*
정렬이 필요한가? No
0이 몇개냐 int blanks
정답이 몇개냐 int answers -> 최저 순위 파악 가능
45 37 28 19 22 03 34 -> 정답
28  0  0  0 44 34 32 -> 나의 답
0 3개 (blanks = 3)
정답 2개 (corrects = 2) -> 최저 순위 5, 최고 순위 2
(2,5) 출력
*/