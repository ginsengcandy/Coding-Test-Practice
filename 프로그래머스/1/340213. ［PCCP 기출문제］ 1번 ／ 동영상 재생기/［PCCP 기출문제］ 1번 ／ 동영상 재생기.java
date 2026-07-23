class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 파라미터와 지역 변수 이름은 같을 수 없다.
        int videoLen = toSeconds(video_len);
        int current = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);
        
        for(String command: commands) {
            // 오프닝 구간 1차 확인
            if(current >= opStart && current <= opEnd) {
                current = opEnd;
            }
            // 이동 명령 수행
            if(command.equals("prev")) {
                current = Math.max(0, current-10);
            }
            if (command.equals("next")) {
                current = Math.min(videoLen, current+10);
            }
            // 오프닝 구간 2차 확인
            if(current >= opStart && current <= opEnd) {
                current = opEnd;
            }
        }
        
        return toTime(current);
 
    }
    // "mm:ss"를 초로 변환
    private int toSeconds(String time) {
        int minute = 60 * Integer.parseInt(time.substring(0,2));
        int seconds = Integer.parseInt(time.substring(3,5));
        
        return minute + seconds;
    }
    // 초를 "mm:ss"로 변환
    private String toTime(int time) {
        int minute = time / 60;
        int second = time % 60;
        
        return String.format("%02d:%02d", minute, second);
    }
}
/*
상태 pos

입력 commands

상태 변화
prev -> max(0, pos-10)
next -> min(video_len, pos+10)

예외
op_start <= pos <= op_end
-> opEnd
*/