import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    7. 스킬 트리
    https://programmers.co.kr/learn/courses/30/lessons/49993
*/
class Solution7 {

    public static void main(String[] args) {

        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

        System.out.println(solution("CBD", skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {

        String[] formalSkillTree = skill.split("");
        Set<String> skillTreeSet = new HashSet<String>();

        for (String skillOrder : formalSkillTree) {
            skillTreeSet.add(skillOrder);
        }

        int formalSkillTreeCount = 0;

        for (String notFormalSkillTree : skill_trees) {

            boolean isFormal = true;

            Queue<String> q = new LinkedList<String>(Arrays.asList(formalSkillTree));

            for (String notFormalSkillOrder : notFormalSkillTree.split("")) {

                if (skillTreeSet.contains(notFormalSkillOrder)) {

                    if (notFormalSkillOrder.equals(q.peek())) {

                        q.poll();

                    } else {

                        isFormal = false;
                        break;

                    }

                }

            }

            if (isFormal)
                formalSkillTreeCount++;
        }

        return formalSkillTreeCount;
    }
}

// public int solution(String skill, String[] skill_trees) {
//     int answer = 0;
//     ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
//     //ArrayList<String> skillTrees = new ArrayList<String>();
//     Iterator<String> it = skillTrees.iterator();

//     while (it.hasNext()) {
//         if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
//             it.remove();
//         }
//     }
//     answer = skillTrees.size();
//     return answer;
// }