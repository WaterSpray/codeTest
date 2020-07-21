/*
    2. 올바른 괄호
    https://programmers.co.kr/learn/courses/30/lessons/12909
*/
public class Solution {
    boolean solution(String s) {

        int counter = 0;
        for (Character bracket : s.toCharArray()) {
            if (bracket == '(') {
                counter++;
            } else {
                if (counter == 0) {
                    return false;
                }
                counter--;
            }
        }
        return counter == 0;
    }
}