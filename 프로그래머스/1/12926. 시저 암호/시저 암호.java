class Solution {
    public String solution(String s, int n) {
        
        char[] charArray = s.toCharArray();
        boolean isCapital;
        boolean isLowerCase;
        int displacement;
        
        for(int i = 0; i < charArray.length; i++) {
            
            isCapital = ((charArray[i] >= 65) && (charArray[i] <= 90));
            isLowerCase = ((charArray[i] >= 97) && charArray[i] <= 122);
            displacement = charArray[i] + n;
            
            if(charArray[i] == 32) continue;
            if((isCapital && displacement > 90) || (isLowerCase && displacement > 122)) {
                charArray[i] += n - 26;
                continue;
            }
            
            charArray[i] += n;
        }
        
        String answer = new String(charArray);
        return answer;
    }
}

/*
* First_attempt
* capitals first (65 ~ 90)
* smallcase later (97~122)
* if(position_after_push > 90), add(6) capitals become smallcase in case of overflow?
* do smallcases become capitals after overflow?
* then, if(position_after_push > 122), subtract(58)
* if(space_32), ignore
*/

/*
* Second_attempt
* Capitals remain capitals, so do lowercases.
* if(space_32), ignore
* if (isCapital && position_after_push > 90) OR
* if(isLowerCase && position_after_push > 122) char += n - 26
* char += n;
*/