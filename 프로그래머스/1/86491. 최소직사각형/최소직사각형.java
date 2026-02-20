/*
Goal: Find the minimum wallet size that can hold all business cards.

Strategy:
For each card, identify which dimension is longer and which is shorter. Track the largest value seen among the "longer" dimensions, and separately track the largest value seen among the "shorter" dimensions across all cards. The wallet's width is determined by the largest of the longer dimensions, and the wallet's height by the largest of the shorter dimensions.

Rationale:
Every card can be rotated, so we can always orient it such that the longer side aligns with the wallet's width and the shorter side aligns with the wallet's height. By consistently categorizing each card's dimensions this way and finding the maximum in each category independently, we arrive at the tightest possible wallet that can accommodate all cards in their optimal orientation.
*/
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int longestWidth = Math.max(sizes[0][0], sizes[0][1]);
        int longestLength = Math.min(sizes[0][0], sizes[0][1]);
        int nowWidth;
        int nowLength;
        for(int i = 0; i < sizes.length; i++) {
            nowWidth = Math.max(sizes[i][0], sizes[i][1]);
            nowLength = Math.min(sizes[i][0], sizes[i][1]);
            if(longestWidth < nowWidth) {
                longestWidth = nowWidth;
            }
            if(longestLength < nowLength) {
                longestLength = nowLength;
            }
        }
        return longestWidth * longestLength;
    }
}