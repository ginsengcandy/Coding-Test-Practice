import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> cards1List = Arrays.asList(cards1);
        List<String> cards2List = Arrays.asList(cards2);
        ListIterator it1 = cards1List.listIterator();
        ListIterator it2 = cards2List.listIterator();
        for(String word:goal) {
            if(it1.hasNext() && word.equals(it1.next())) continue;
            it1.previous();
            if(it2.hasNext() && word.equals(it2.next())) continue;
            return "No";
        }
        return "Yes";
    }
}