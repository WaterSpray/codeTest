import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    2. K번째 수 
    https://programmers.co.kr/learn/courses/30/lessons/42748
*/
class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        System.out.println(Arrays.toString(sol.solution(arr, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {

        List<Integer> answer = new ArrayList<Integer>();

        for (int[] command : commands) {

            int startIndex = command[0] - 1;
            int endIndex = command[1];
            int pickIndex = command[2] - 1;

            int[] commandCopy = Arrays.copyOfRange(array, startIndex, endIndex);
            Arrays.sort(commandCopy);

            answer.add(commandCopy[pickIndex]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
