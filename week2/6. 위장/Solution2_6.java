/*
     6. 위장
    https://programmers.co.kr/learn/courses/30/lessons/42578
*/
import java.util.HashMap;
import java.util.Map;

public class Solution2_6 {
	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> cloteshMap = new HashMap<>();

		for (String[] cloth : clothes) {

			cloteshMap.put(cloth[1], cloteshMap.getOrDefault(cloth[1], 0) + 1);

		}

		for (Map.Entry<String, Integer> cloth : cloteshMap.entrySet()) {

			answer *= (cloth.getValue() + 1);

		}

		answer--;

		return answer;

	}
}