class Solution {
    public int solution(int n) {
        int answer = 0;
        // 3진수로 변환
        String tetra = Integer.toString(n,3);
        // 문자열 반전
        String tetraReverse = "";
        for(int i = tetra.length()-1;i >= 0; i--)
            tetraReverse = tetraReverse + tetra.charAt(i);
        // 3진수 -> 10진수
        answer = Integer.parseInt(tetraReverse, 3);
        
        return answer;
    }
}