class Solution {

    public int solution(int n, int w, int num) {

        int row = (num - 1) / w;

        int col = (row % 2 == 0)
                ? (num - 1) % w
                : w - 1 - (num - 1) % w;

        int lastRow = (n - 1) / w;
        int lastCnt = n % w;

        if (lastCnt == 0)
            lastCnt = w;

        int answer = 0;

        for (int r = row; r <= lastRow; r++) {

            // 마지막 줄은 존재하는 열인지 검사
            if (r == lastRow) {

                if (lastCnt != w) {

                    if (r % 2 == 0) {

                        if (col >= lastCnt)
                            continue;

                    } else {

                        if (col < w - lastCnt)
                            continue;
                    }
                }
            }

            answer++;
        }

        return answer;
    }
}