import java.lang.StringBuilder;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char c;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(Character.isAlphabetic(c)) {
                switch(c) {
                    case 'z' -> {
                        sb.append(0);
                        i+=4;
                    }
                    case 'o' -> {
                        sb.append(1);
                        i+=3;
                    }
                    case 't' -> {
                        if(s.charAt(++i) == 'w') {
                            sb.append(2);
                            i+=2;
                        } else {
                            sb.append(3);
                            i+=4;
                        }
                    }
                    case 'f' -> {
                        if(s.charAt(++i) == 'o') {
                            sb.append(4);
                            i+=3;
                        } else {
                            sb.append(5);
                            i+=3;
                        }
                    }
                    case 's' -> {
                        if(s.charAt(++i) == 'i') {
                            sb.append(6);
                            i+=2;
                        } else {
                            sb.append(7);
                            i+=4;
                        }
                    }
                    case 'e' -> {
                        sb.append(8);
                        i+=5;
                    }
                    case 'n' -> {
                        sb.append(9);
                        i+=4;
                    }
                }
                i--; 
            } else {
                sb.append(s.charAt(i));
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}

/*
* switch case 문에서 default를 안 써도 되는 줄 몰랐다.
* 숫자일 때는 i--를 할 필요가 없다는 점을 간과했다. 
*/