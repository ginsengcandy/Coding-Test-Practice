import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int length = arr1.length;
        int[][] answer = new int[length][arr1[0].length];
        for(int i = 0;i<length;i++){
            for(int j = 0;j<arr1[0].length;j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}