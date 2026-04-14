import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 최악의 경우 (잃어버린 학생들 모두 여벌옷이 없을 때)에서 시작
        int answer = n - lost.length;
        
        // lost를 set으로 변환
        // Java 8 이상의 Stream API
        Set<Integer> lostCopy = Arrays.stream(lost)
            .boxed()
            .sorted() // 추가
            .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> reserveCopy = Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toSet());
        
        // 여벌옷을 가져왔으면서 잃어버린 학생들 추리기
        // reserveCopy에서도 삭제
        for(int res : reserve) {
            if(lostCopy.contains(res)) {
                answer++;
                lostCopy.remove(res);
                reserveCopy.remove(res);
                continue;
            }
        }
        
        // lostCopy에 남은 학생들과 reserveCopy에 남은 학생들을 비교하여 추가 생존자 구하기
        for(int loser : lostCopy) {
            if(reserveCopy.contains(loser-1)) {
                answer++;
                reserveCopy.remove(loser-1);
                continue;
            }
            if(reserveCopy.contains(loser+1)) {
                answer++;
                reserveCopy.remove(loser+1);
                continue;
            }
        }

        return answer;
    }
}
/*
번호가 체격순 -> 1번이 2번보다 크다면, 2번은 3번보다 반드시 크다.
목표 : 최대한 많은 학생이 체육복을 입는 것.
reserve 배열 내 번호와 lost 배열 내 번호가 겹칠 수 있다. 이 경우 여벌의 체육복을 가져왔지만 도난당했으므로 빌려줄 수 없다.
힌트 : 그리디 알고리즘 (모든 경우의 수를 순회)
*/
/* 접근
최악의 경우, lost에 포함된 학생들이 reserve에 포함된 학생들 중 어느 누구로부터도 빌리지 못하는 경우 -> answer = n - lost.length;

목표는 최댓값을 구하는 것이므로 answer가 증가하는 조건 파악
1) 자기 자신에게 빌려주는 경우 (reserve이면서 lost 동시에 존재, 자신이 우선)
2) 인접한 타인에게 빌려주는 경우 (reserve에 있는 원소 중 lost에 없으면서 자기 자신과 번호가 인접해야 함)

역발상 : lost가 아니라 reserve를 순회하자.
reserve를 순회하며 lostSet에 있으면 answer 1 증가, lostSet.remove() 실행
남은 lostSet으로 reserve 내 원소를 순회하면서 추가로 빌리기

reserve의 원소를 복사한 동적 집합 생성(Set<Integer> reserveCopy)
lost의 원소를 두 번 순회
1회차 -> lost이면서 reserve 동시에 있는 학생들 추리기
lost의 원소를 작은 수부터 순회, 자기 자신, 직전 원소 또는 직후 원소가 reserveCopy에 있는지 확인. 자기 자신이 있다면 빌릴 필요가 없으므로 reserveCopy에서 자기 자신을 삭제하고 skip
자기 자신이 없다면 직전 원소를 우선, 없다면 직후 원소를 선택한 뒤 현재 체육복을 가져온 사람 수 1 증가 (k = 4)
이후 reserveCopy에서 선택된 원소 제거.
lost의 다음 원소로 이동, 반복
k 반환
*/