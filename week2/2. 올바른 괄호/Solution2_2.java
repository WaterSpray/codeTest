import java.util.Map;

/*
    2. 올바른 괄호
    https://programmers.co.kr/learn/courses/30/lessons/12909
*/
public class Solution2_2 {
    public static void main(String[] args) {

        String s = "(()(";

        System.out.println(solution(s));

    }

    public static boolean solution(String s) {

        int stack = 0;

        if (s.charAt(0) == ')') {
            return false;
        }

        for (char c : s.toCharArray()) {

            switch (c) {
                case '(':

                    stack += 1;

                    break;

                case ')':

                    stack -= 1;

                    if (stack < 0) {
                        return false;
                    }

                    break;

                default:
                    break;
            }

        }

        return stack == 0 ? true : false;
    }
}