package Greedy.BigNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionFour {
    public String solution(String number, int k) {
        StringBuilder answerSB = new StringBuilder();
        int startIdx=0;
        int endIdx= number.length();
        int remainder = endIdx - k;

        List<Character> numberList = new ArrayList<>();
        List<Character> listForMax = new ArrayList<>();

        for(char c : number.toCharArray()){
            numberList.add(c);
            listForMax.add(c);
        }

        while(true){
            char maxChar = Collections.max(listForMax);
            int digitIdx = number.indexOf(maxChar,startIdx);
            if(endIdx-(digitIdx+1) >= remainder-1){
                startIdx = digitIdx+1;
                answerSB.append(maxChar);
                remainder--;
                listForMax.clear();
                listForMax.addAll(numberList.subList(startIdx,endIdx));
            }else{
                listForMax.remove(listForMax.indexOf(maxChar));
            }
            if(remainder == 0){
                break;
            }
        }
        return answerSB.toString();
    }

}
