import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int size;
        boolean canPlace;
        
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--) {
            
            size = mats[i];
    
            for(int row = 0; row <= park.length - size; row++) {
                for (int col = 0; col <= park[0].length - size; col++) {
                    
                    canPlace = true;
                    
                    for(int rowOffset = 0; rowOffset < size; rowOffset++) {
                        for (int colOffset = 0; colOffset < size; colOffset++) {
                            
                            if (!park[row + rowOffset][col + colOffset].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                        
                        if (!canPlace) {
                            break;
                        }
                    }
                    
                    if(canPlace) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
}
/*
입력
- mats 돗자리 크기 목록
- park 공원의 현재 상태

상태
- 현재 돗자리 크기 (int size)
- 현재 위치 (row, col)
- 돗자리 설치 가능 여부(boolean canPlace)

상태 변화
- 돗자리 크기는 큰 것에서 작은 순서대로 
- 현재 위치는 (0,0)에서 (park.length - size, park[0].length - size 까지)
- 현재 영역 확인하다가 -1이면 계속 검사, 아니면 canPlace = false 지정 후 검사 중지, 다음 위치로 이동

예외 처리
- 돗자리가 공원 밖으로 나가는 경우: 행/열을 각각 park.length-size, park[0].length-size까지 검사함으로써 예방
- 모든 돗자리를 놓을 수 없는 경우: return -1 필요
*/