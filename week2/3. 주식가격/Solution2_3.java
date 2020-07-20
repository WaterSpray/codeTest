import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    3. 주식 가격
    https://programmers.co.kr/learn/courses/30/lessons/42584
*/
public class Solution2_3 {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };

        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {

        int[] timeCountArray = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int timer = 0;

            for (int j = i + 1; j < prices.length; j++) {

                timer++;
                timeCountArray[i] = timer;

                if (prices[i] > prices[j])
                    break;

            }
        }

        return timeCountArray;
    }

    // 처음 문제 풀이 방법
    // public static int[] solution(int[] prices) {

    // List<Price> priceList = new ArrayList<>();

    // for (int i = 0; i < prices.length; i++) {

    // for (Price price : priceList) {
    // price.comparePriceAndAddTime(prices[i]);
    // }

    // priceList.add(new Price(prices[i]));
    // }

    // return priceList.stream().mapToInt(price -> price.getTime()).toArray();
    // }

}

class Price {

    private int price;
    private int time;
    private boolean isStopTimer;

    public int getTime() {
        return this.time;
    }

    Price(int price) {
        this.price = price;
        this.time = 0;
        this.isStopTimer = false;
    }

    public void comparePriceAndAddTime(int otherPrice) {

        if (this.isStopTimer) {
            return;
        }

        if (this.price <= otherPrice) {
            this.time++;
            return;
        }

        if (this.price > otherPrice) {
            this.time++;
            this.isStopTimer = true;
            return;
        }

    }

}