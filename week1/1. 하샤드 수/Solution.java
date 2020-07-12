/*
 * 1. 하샤드 수 
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
class Solution {

    public boolean solution(int x) {

        int sum = sumOfDigit(x);

        return x % sum == 0;
    }

    private int sumOfDigit(int x) {

        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

}