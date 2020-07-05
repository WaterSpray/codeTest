import java.util.Arrays;

/*
    2. K번째 수 
    https://programmers.co.kr/learn/courses/30/lessons/42748
*/
class Solution {

    public int[] solution(int[] array, int[][] commands) {

        int[] resultArray = new int[commands.length];

        int index = 0;
        for (int[] command : commands) {

            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;

            int[] slicedArray = Arrays.copyOfRange(array, i, j);

            Arrays.sort(slicedArray);

            resultArray[index++] = slicedArray[k];
            ;
        }

        return resultArray;
    }

}
