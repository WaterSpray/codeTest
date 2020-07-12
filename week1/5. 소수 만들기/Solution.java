/*
    5. 소수 만들기
    https://programmers.co.kr/learn/courses/30/lessons/12915

*/
class Solution5 {

    public static void main(String[] args) {

        Solution5 sol1 = new Solution5();

        int[] nums = { 1, 2, 7, 6, 4 };

        System.out.println(sol1.solution(nums));
    }

    public int solution(int[] nums) {
        int numsLength = nums.length;

        int primeNumberCount = 0;

        for (int i = 0; i < numsLength - 2; i++) {
            for (int j = i + 1; j < numsLength - 1; j++) {
                for (int k = j + 1; k < numsLength; k++) {

                    int total = nums[i] + nums[j] + nums[k];
                    if (checkPrimeNumber(total)) {
                        primeNumberCount++;
                    }
                }
            }
        }

        return primeNumberCount;
    }

    public boolean checkPrimeNumber(int number) {

        boolean checkPrime = true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                checkPrime = false;
                return checkPrime;
            }
        }

        return checkPrime;
    }

}
