class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoLen = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);
        
        for (String command : commands) {
            
            
            // 오프닝이 끝나는 위치로 이동해야 하는지 검사
            if (position >= opStart && position <= opEnd) {
                position = opEnd;
            }
            // 명령 수행
            if (command.equals("prev")) {
                position = Math.max(0, position-10);
            } else {
                position = Math.min(videoLen, position+10);
            }
            // 명령 수행 후 오프닝 위치에 있는지 재확인
            if (position >= opStart && position <= opEnd) {
                position = opEnd;
            }
        }
        
        // 정수 형태의 position을 "mm:ss" 형태로 변환 후 출력
        int minute = position / 60;
        int second = position % 60;
        
        return String.format("%02d:%02d", minute, second);
        
    }
    // 문자열 -> 정수(초)로 시간을 변환해주는 함수
    private int toSeconds(String time) {
        int minute = Integer.parseInt(time.substring(0,2));
        int second = Integer.parseInt(time.substring(3,5));
        
        return minute * 60 + second;
    }
    
    
}
/*
상태
pos
입력
commands - prev, next
상태 변화
pos + 10 또는 pos - 10 (초)
예외
op_start <= pos <= op_end
*/
