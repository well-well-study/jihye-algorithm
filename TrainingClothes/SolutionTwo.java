package Greedy.TrainingClothes;

import java.util.ArrayList;

public class SolutionTwo {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> lostAL = new ArrayList();
        ArrayList<Integer> reserveAL = new ArrayList();

        for (Integer l : lost) {
            lostAL.add(l);
        }
        for (Integer r : reserve) {
            // 도난당한애 = 여벌있는애
            if(lostAL.contains(r)){
                lostAL.remove(r);
            }else{
                reserveAL.add(r);
            }
        }

        ArrayList<Integer> lostALClone = new ArrayList<>(lostAL);

        for (Integer l : lostALClone) {
            Integer pre = l - 1;
            Integer post = l + 1;
            if (reserveAL.contains(pre)) {
                reserveAL.remove(pre);
                lostAL.remove(l);
                continue;
            }

            if (reserveAL.contains(post)) {
                reserveAL.remove(post);
                lostAL.remove(l);
            }
        }

        return n-lostAL.size();
    }
}
