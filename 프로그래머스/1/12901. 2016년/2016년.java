class Solution {
    public String solution(int month, int day) {
        String answer;
        int standardDate = 5; // 조건: 1월 1일은 금요일이므로
        
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] dayEnums = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        int elapsedDays = 0;
        for(int i = 0; i < month - 1; i++) {
            elapsedDays += days[i];
        }
        elapsedDays += day - 1; // 1월 1일은 0일 경과이므로
        answer = dayEnums[(elapsedDays + standardDate) % 7];
        
        return answer;
    }
}