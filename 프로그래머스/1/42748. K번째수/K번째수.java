import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            //nice use of variables
            int start = commands[i][0]-1; // conversion from 1-based to 0-based index.
            int end = commands[i][1]; // copyOfRange is open in the end: keep 1-based.
            int loc = commands[i][2]-1;
            
            int[] arrayCopy = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arrayCopy);
            answer[i] = arrayCopy[loc];
        }
        
        return answer;
    }
}

/*
Check if indexes are given as 1-based or 0-based.  
When converting list to arrays of primitive classes, make sure list houses wrapper classes that need to be converted first.
*/
