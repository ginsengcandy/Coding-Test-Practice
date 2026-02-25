/*
Data Structure: Arrays
Reason: Sorting non-primitive types(String), time complexity is equal to Collections.sort() -> Tim Sort. Converting to Collections results in unnecessary memory allocations.
Time/Space complexity
: O(n)
Edge Cases
: None

Schemes - 1
Use something like Comparator.comparingChar(word -> word.charAt(n));
This will automatically rearrange the elements based on their (n)th character.
But Comparator.comparingChar() doesn't exist, so we have to user Comparator.comparingInt()

Result: Answer is always an empty array.
Reaons: 1) sorted the original String but did not allocate its value to the variable answer. 2) Missed lexicographical sorting when the compared values are equal. 

Mistake #1
Missed type declaration in the lambda expression(String s -> s.charAt(n))
*/
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, 
                    Comparator.comparingInt((String s) -> s.charAt(n))
                   .thenComparing(Comparator.naturalOrder()));
        return strings;
    }
}
/*
Arrays.sort()는 배열을 오름차순(작은 값 → 큰 값)으로 정렬합니다.
객체 배열을 정렬할 때는 Comparator를 이용해 정렬 기준을 직접 정의할 수 있습니다.
Arrays.sort(people, Comparator.comparingInt(p -> p.age));
출처: https://hianna.tistory.com/922 [어제 오늘 내일:티스토리]

*/