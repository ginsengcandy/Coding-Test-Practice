import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int[] command:commands){
            int start = command[0]-1;
            int end = command[1];
            int loc = command[2]-1;
            int[] arrayCopy = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arrayCopy);
            list.add(arrayCopy[loc]);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
