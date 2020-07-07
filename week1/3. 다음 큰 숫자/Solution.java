/*
 * 3. 다음 큰 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12911
 */
class Solution {

    public int solution(int n) {

        int nCount = countOne(n);

        while (countOne(++n) != nCount) {
        }

        return n;
    }

    private int countOne(int n) {

        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >>> 1;
        }

        return count;
    }

}
