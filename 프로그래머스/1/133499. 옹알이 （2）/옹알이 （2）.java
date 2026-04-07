class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possibles = {"aya", "ye", "woo", "ma"};
        for(String word : babbling) {
            if(canSpeak(possibles, word)) {
                answer++;
                System.out.println(word);   
            }
        }
        return answer;
    }
    
    private boolean canSpeak(String[] possibles, String word) {
        String recent="";
        StringBuilder sb = new StringBuilder(word);
        
        for (int i = 0; i < possibles.length; i++) {
            if(sb.indexOf(possibles[i]) == 0) {
                if(possibles[i].equals(recent)) {
                    return false;
                }
                sb.delete(0, possibles[i].length());
                recent = possibles[i];
                i = -1; // 옹알이 루프의 처음으로 돌아감
                if(sb.length() <= 0) {
                    return true; // 마지막까지 발음 가능하면 true 반환
                }
            }
        }
        
        return false; // 일치하는 게 없음
    }
}
/*
어제의 레슨:
HashSet()을 사용하여 탐색 시간을 O(1)로 줄일 수 있다.
오늘의 레슨
StringBuilder는 java.lang 패키지에 있어 자동으로 import됨
*/