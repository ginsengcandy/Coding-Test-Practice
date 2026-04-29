import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // Map에 포함된 값들이 점수를 얻으면 더하고, 대응하는 값들이 점수를 얻으면 차감한다. 총합이 0 이상이면 Map에 포함된 값으로, 음수이면 대응하는 값을 선택하여 문자열을 생성한다.
        Map<Character, Integer> priorityMap = new LinkedHashMap<>();
        priorityMap.put('R', 0);
        priorityMap.put('C', 0);
        priorityMap.put('J', 0);
        priorityMap.put('A', 0);
        for(int i = 0; i < survey.length; i++) {
            // 첫번째 문자 확인
            char firstChar = survey[i].charAt(0);
            
            switch(firstChar) {
                case 'R':
                    priorityMap.put('R', priorityMap.getOrDefault('R', 0) - (choices[i]-4));
                    break;
                case 'T':
                    priorityMap.put('R', priorityMap.getOrDefault('R', 0) + (choices[i]-4));
                    break;
                case 'C':
                    priorityMap.put('C', priorityMap.getOrDefault('C', 0) - (choices[i]-4));
                    break;
                case 'F':
                    priorityMap.put('C', priorityMap.getOrDefault('C', 0) + (choices[i]-4));
                    break;
                case 'J':
                    priorityMap.put('J', priorityMap.getOrDefault('J', 0) - (choices[i]-4));
                    break;
                case 'M':
                    priorityMap.put('J', priorityMap.getOrDefault('J', 0) + (choices[i]-4));
                    break;
                case 'A':
                    priorityMap.put('A', priorityMap.getOrDefault('A', 0) - (choices[i]-4));
                    break;
                case 'N':
                    priorityMap.put('A', priorityMap.getOrDefault('A', 0) + (choices[i]-4));
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character key : priorityMap.keySet()) {
            if(priorityMap.get(key) < 0) {
                switch(key) {
                    case 'R':
                        sb.append('T');
                        break;
                    case 'C':
                        sb.append('F');
                        break;
                    case 'J':
                        sb.append('M');
                        break;
                    case 'A':
                        sb.append('N');
                        break;
                }
            }
            else {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}