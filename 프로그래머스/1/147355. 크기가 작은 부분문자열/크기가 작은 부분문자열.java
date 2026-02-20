/*
Objective: compare values in the string while iterating

Strategy: convert values to Long, instead of BigInteger

Ground: the length of p is less than 18 -> when converted to number type, it can be covered by long types(type long can handle up to 20 digits of decimal number)

Approach:
1) convert p to long -> to compare against its counterparts derived from t
2) convert p's counterpart from t
3) compare converted p and its converted counterpart
4) if p is bigger, add value to answer
5) reassign p's counterpart by moving the iterator until its end reaches the end index of t
6) start over step 2 with reassigned iterator
*/

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pValue = Long.parseLong(p);
        
        for(int i = 0;i <= t.length() - pLength; i++) {
            long tValue = Long.parseLong(t.substring(i, i+pLength));
            if(tValue <= pValue) {
                answer++;
            }
        }
        return answer;
    }
}


