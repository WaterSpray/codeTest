import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
    1. 완주하지 못한 선수
    https://programmers.co.kr/learn/courses/30/lessons/42576
*/
public class Solution {
    public static void main(String[] args) {

        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };

        System.out.println(solution(participant, completion));
        System.out.println(solution2(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }

    public static String solution2(String[] participant, String[] completion) {

        Map<String, Integer> checkerMap = new HashMap<>();

        for (String person : participant) {
            checkerMap.put(person, checkerMap.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {
            checkerMap.put(person, checkerMap.getOrDefault(person, 0) - 1);
        }

        Iterator<Entry<String, Integer>> it = checkerMap.entrySet().iterator();

        while (it.hasNext()) {

            Entry<String, Integer> mapEntry = it.next();

            if (mapEntry.getValue() == 1) {
                return mapEntry.getKey();
            }
        }

        return null;
    }
}