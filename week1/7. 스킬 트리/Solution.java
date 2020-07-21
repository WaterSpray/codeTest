/*
    7. 스킬 트리
    https://programmers.co.kr/learn/courses/30/lessons/49993
*/
class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            if (isAvailable(skill, tree)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isAvailable(String skill, String tree) {

        int index1 = 0;

        for (char s : skill.toCharArray()) {

            int index2 = tree.indexOf(s);

            if (index2 == -1) {
                index1 = index2;
                continue;
            }

            if (index1 == -1) {
                return false;
            }

            if (index1 > index2) {
                return false;
            }
            index1 = index2;
        }

        return true;
    }
}
