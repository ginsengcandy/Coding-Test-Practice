import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        TreeMap<Character, Integer> mapX = stringToMap(X);
        TreeMap<Character, Integer> mapY = stringToMap(Y);
        TreeMap<Character, Integer> mapXY = findCommonMap(mapX, mapY);
        answer = toPair(mapXY);
        return answer;
    }
    
    // 1. 문자열을 TreeMap으로 바꿔주는 함수
    private TreeMap<Character, Integer> stringToMap(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);   
        }
             return map;
    }
    // 2. 두 TreeMap을 받아 공통된 key-value로 구성된 TreeMap을 반환하는 함수
    private TreeMap<Character, Integer> findCommonMap(TreeMap<Character, Integer> mapX, TreeMap<Character, Integer> mapY) {
        TreeMap<Character, Integer> commonTreeMap = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<Character, Integer> entry : mapX.entrySet()) {
            Character key = entry.getKey();
            if (mapY.containsKey(key)) {
                commonTreeMap.put(key, Math.min(entry.getValue(), mapY.get(key)));
            }
        }
        return commonTreeMap;
    }
    // 3. TreeMap을 받아 짝꿍을 계산하여 return하는 함수
    private String toPair(TreeMap<Character, Integer> map) {
        if(map.isEmpty()) return "-1";
        if(map.firstKey().equals('0')) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer>  entry : map.entrySet()) {
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }
}
/*
#1
100
2345

map으로 저장(숫자, 횟수)
map은 불변과 가변 맵이 있음 -> 가변 맵인 HashMap<>을 사용해야 숫자를 읽으면서 추가 가능
TreeMap은 키 기준 오름차순 정렬해줌 -> 내림차순은 Comparator.reverseOrder()를 인수로 넣어주면 됨
mapX = new TreeMap<String, Integer>(Comparator.reverseOrder())
mapY = new TreeMap<String, Integer>(Comparator.reverseOrder())
mapX = {"1",1,"0",2}
mapY = {"5", 1, "4",1, "3",1,"2", 1}
겹치는 키가 없으므로 -1


#2
100
203045
mapX = {"1", 1, "0", 2}
mapY = {"5",1, "4", 1, "3", 1, "2", 1, "0", 2}
0 두개 겹침 -> "00" -> 0으로 시작하면 0으로 반환

#3
12321
42531

mapX = {"3", 1, "2", 2, "1", 2}
mapY = {"5", 1, "4", 1, "3", 1, "2", 1, "1", 1}
mapXY = {"3", 1, "2", 1, "1", 1}
return 321

1. 문자열을 TreeMap으로 바꿔주는 함수
2. 두 TreeMap을 받아 공통된 key-value로 구성된 TreeMap을 반환하는 함수
3. TreeMap을 받아 짝꿍을 계산하여 return하는 함수

*/