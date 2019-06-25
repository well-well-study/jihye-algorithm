package Greedy.TrainingClothes;

public class Main {
    public static void main(String[] args) {
        SolutionTwo sol = new SolutionTwo();
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(sol.solution(5,lost,reserve));
    }
}
