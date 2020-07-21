import java.util.HashMap;
import java.util.Map;

/*
    1. 완주하지 못한 선수
    https://programmers.co.kr/learn/courses/30/lessons/42576
*/
public class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = null;

        Map<String, Integer> name = new HashMap<>();

        for (String player : participant) {
            Integer counter = name.get(player);
            if (counter == null) {
                name.put(player, 1);
            } else {
                name.put(player, counter + 1);
            }
        }

        for (String player : completion) {
            Integer counter = name.get(player);
            name.put(player, counter - 1);
        }

        for (Map.Entry<String, Integer> player : name.entrySet()) {
            if (player.getValue() == 1) {
                answer = player.getKey();
                return answer;
            }
        }
        return answer;
    }
}