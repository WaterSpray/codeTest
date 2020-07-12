import java.util.Arrays;

/*
 * 1. 하샤드 수 
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 19;
        System.out.println(solution.solution(x));
    }

    public boolean solution(final int x) {
        int sum = Arrays.asList(String.valueOf(x).split("")).stream().mapToInt(Integer::parseInt).sum();
        return x % sum == 0 ? true : false;
    }

}
