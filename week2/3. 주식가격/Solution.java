/*
    3. 주식 가격
    https://programmers.co.kr/learn/courses/30/lessons/42584
*/
public class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            answer[i] = countPriceTerm(i, prices);
        }
        return answer;
    }

    private int countPriceTerm(int index, int[] prices) {

        int price = prices[index];
        int count = 0;

        for (int i = index + 1; i < prices.length; i++) {
            count++;
            if (price > prices[i]) {
                break;
            }
        }
        return count;
    }
}