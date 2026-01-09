class Solution {
    public int solution(int angle) {
        int answer = -1;
        if(0<angle && angle <=180){
            if(angle<90){
                return 1;
            } //예각
            if(angle==90){
                return 2;
            } //직각
            if(angle<180){
                return 3;
            } //둔각
            if(angle==180){
                return 4;
            } //평각
        }
        return answer;
    }
}