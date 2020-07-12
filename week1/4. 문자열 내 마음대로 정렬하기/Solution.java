import java.util.Arrays;
import java.util.Comparator;

/*
    4. 문자 내마음대로 정렬하기
    https://programmers.co.kr/learn/courses/30/lessons/12915
*/
class Solution {

    public String[] solution(String[] strings, int n) {

        SortString sort = new SortString(n);

        // 익명 함수형
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int args = s1.charAt(n) - s2.charAt(n);
                if (args == 0) {
                    args = s1.compareTo(s2);
                }
                return args;
            }
        });

        // 람다 표현식을 이용
        // Arrays.sort(strings, Comparator.comparingInt((String s) ->
        // s.charAt(n)).thenComparing(s -> s));

        return strings;
    }
}
