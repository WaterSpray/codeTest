import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    4. 기능개발
    https://programmers.co.kr/learn/courses/30/lessons/42586
*/
public class Solution2_4 {
    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> progressesQueue = new LinkedList<Integer>();
        Queue<Integer> speedsQueue = new LinkedList<Integer>();
        List<Integer> deployCountList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressesQueue.add(progresses[i]);
            speedsQueue.add(speeds[i]);
        }

        int days = 1;
        int deployCount = 0;

        while (true) {

            Integer progress = progressesQueue.peek();
            Integer speed = speedsQueue.peek();
            if (progress != null) {

                if (100 <= (progress.intValue() + (days * speed.intValue()))) {
                    progressesQueue.poll();
                    speedsQueue.poll();
                    deployCount++;

                    if (progressesQueue.peek() == null) {
                        deployCountList.add(deployCount);
                    }

                } else if (deployCount > 0) {
                    deployCountList.add(deployCount);
                    deployCount = 0;
                } else {
                    days++;
                }

            } else {
                break;
            }
        }

        return deployCountList.stream().mapToInt(i -> i).toArray();
    }

}

/**
 * 
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}

 */