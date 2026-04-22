import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> shortestKeyMap = convert(keymap);
        for(int i = 0; i < targets.length; i++) {
            answer[i] = count(shortestKeyMap, targets[i]);
        }
        return answer;
    }
    
    // 최단 클릭 수를 저장한 맵과 문자열을 받아 필요한 총 클릭 수를 반환
    private int count(Map<Character, Integer> shortestKeyMap, String str) {
        int count = 0;
        char key;
        for(int i = 0; i < str.length(); i++) {
            key = str.charAt(i);
            if(shortestKeyMap.containsKey(key)) {
                count += shortestKeyMap.get(key);
            }
            else return -1;
        }
        return count;
    }
    
    // 문자열 배열을 받아 문자별로 최단 클릭 수를 저장한 맵 반환
    private Map<Character, Integer> convert(String[] keymap) {
        Map<Character, Integer> shortestKeyMap = new HashMap<Character, Integer>();
        for(String str : keymap) {
            int i = 1;
            char key;
            while(i <= str.length()) {
                key = str.charAt(i-1);
                if(shortestKeyMap.containsKey(key)) {
                    Integer value = shortestKeyMap.get(key);
                    shortestKeyMap.replace(key, Math.min(value, i));
                }
                else {
                    shortestKeyMap.put(key, i);
                }
                i++;
            }
        }
        
        return shortestKeyMap;
    }
}
/*
우리는 특정 문자열을 만들 수 있는지, 만들 수 있다면 몇 번의 클릭이 필요한지만 알면 된다.
1번 케이스의 키맵을 키별 가장 짧은 클릭 수로 정리하면
(A,1), (B,1), (C, 2), (D, 5), (E, 3), (F, 4)다.
ABCD라는 문자열을 만들기 위해 필요한 값은 1 + 1 + 2 + 5 = 9다.
따라서 키맵에 들어있는 데이터를 가지고 키별 가장 짧은 클릭 수와 매핑하는 새로운 키맵만 만들 수 있으면 된다.
abacd를 순회하며 키맵에 추가한다.
i = 1로 초기화한다
첫번째 문자를 순회한다. 키맵에 a가 없다. (a,1)을 추가한다. 1은 i값이다.
i = i + 1로 업데이트한다.
다음 문자를 순회한다. 키맵 b가 없다. (b, 2)을 추가한다. 2는 i값이다.
다음 문자를 순회한다. 키맵에 a가 있다. value값(1)과 i를 비교한다. 더 작은 값으로 대체한다. 
더이상 순회할 문자가 없으면 i를 1로 초기화한다.
다음 문자열로 넘어간 뒤 반복한다.
더이상 순회할 문자열이 없으면 종료하고 키맵을 반환한다.
*/