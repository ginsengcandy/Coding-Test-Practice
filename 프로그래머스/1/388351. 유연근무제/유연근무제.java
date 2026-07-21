class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {

            // 희망 출근 시간을 분 단위로 변환
            int schedule = toMinutes(schedules[i]);

            // 희망 출근 시간 + 10분
            int deadline = schedule + 10;

            boolean isSuccess = true;

            // 7일 검사
            for (int j = 0; j < 7; j++) {

                // 현재 요일 계산
                int day = (startday - 1 + j) % 7;

                // 월요일 ~ 금요일만 검사
                if (day < 5) {

                    // 실제 출근 시간을 분 단위로 변환
                    int arrival = toMinutes(timelogs[i][j]);

                    // 허용 시간보다 늦게 출근했다면 탈락
                    if (arrival > deadline) {
                        isSuccess = false;
                        break;
                    }
                }
            }

            // 7일 동안 한 번도 지각하지 않았다면
            if (isSuccess) {
                answer++;
            }
        }

        return answer;
    }

    // HHMM 형태의 시간을 분으로 변환
    private int toMinutes(int time) {

        int hour = time / 100;
        int minute = time % 100;

        return hour * 60 + minute;
    }
}