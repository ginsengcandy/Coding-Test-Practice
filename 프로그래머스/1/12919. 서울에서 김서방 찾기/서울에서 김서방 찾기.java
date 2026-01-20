class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        String answer = "김서방은 ";
        for(int i = 0;i < 1000;i++){
            if(seoul[i].equals("Kim")){
                index = i;
                break;
            }
        }
        return answer + index + "에 있다";
    }
}