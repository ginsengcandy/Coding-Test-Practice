import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        List<String> list = Arrays.asList(phone_number.split(""));
        for(int i = 0;i<list.size()-4;i++)
            list.set(i,"*");
        answer = String.join("", list); 
        return answer;
    }
}