class Solution {
    public int solution(int n, int m, int[] section) {
        int j = section[0] - 1; // 현재까지 칠한 위치
        int count = 0;
        for(int i = 0; i < section.length; i++) {
            if(j >= section[i]) {
                continue;   
            }
            j = section[i] - 1;
            j+=m;
            count++;
            if(j >= n) break;
        }
        return count;
    }
}