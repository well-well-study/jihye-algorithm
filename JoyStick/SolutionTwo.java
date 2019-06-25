package Greedy.JoyStick;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionTwo {
    public int howFar(char to){
        return Math.min(to-'A','Z'-to+1);
    }

    public int solution(String name) {
        int answer = 0;

        // 위아래 이동
        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            if (c!= 'A') {
                answer += howFar(c);
            }
        }

        // 왼오이동
        int cursorCount = name.length()-1;
        if(name.contains("A")){
            String regEx = "[A]+";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(name);

            int tmpCount;
            while(matcher.find()){
                tmpCount = (matcher.start()-1) * 2 +((name.length() -1) - (matcher.end()-1));
                cursorCount = Math.min(tmpCount,cursorCount);
            }
        }

        answer+=cursorCount;
        return answer;
    }
}
