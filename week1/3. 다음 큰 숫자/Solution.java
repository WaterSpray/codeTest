/*
 * 3. 다음 큰 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12911
 */
class Solution {

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(78));

    }

    public int solution(int n) {

        int countOfOne = countOne(n);

        while (countOfOne != countOne(++n)) {

        }

        return n;
    }

    public int countOne(int n) {
        int count = 0;

        String binary = Integer.toBinaryString(n);

        for (String number : binary.split("")) {
            if (number.equals("1")) {
                count++;
            }
        }

        return count;
    }


    //문제 풀이를 보는데 거기에서 더 이런식으로도 줄일수 있구나 하면서 보고 있어요 형.. 신기하네요 
    // public int nextBigNumber(int n) {
    //     int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
    //     return n + postPattern | smallPattern;
    // }
    // public static void main(String[] args) {
    //     int n = 78;
    //     System.out.println(new TryHelloWorld().nextBigNumber(n));
    // }
}
