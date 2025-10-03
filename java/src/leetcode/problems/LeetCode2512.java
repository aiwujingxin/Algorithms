package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/16/25 15:45
 */
public class LeetCode2512 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = student_id.length;
        int[][] score = new int[n][2];
        HashSet<String> po = new HashSet<>();
        HashSet<String> ne = new HashSet<>();
        Collections.addAll(po, positive_feedback);
        Collections.addAll(ne, negative_feedback);
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (String s : report[i].split(" ")) {
                if (po.contains(s)) {
                    t += 3;
                } else if (ne.contains(s)) {
                    t -= 1;
                }
            }
            score[i] = new int[]{t, student_id[i]};
        }
        Arrays.sort(score, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(score[i][1]);
        }
        return list;
    }
}
