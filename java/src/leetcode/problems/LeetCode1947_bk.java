package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:46
 */
public class LeetCode1947_bk {

    int max;
    int[][] mentors;
    int[][] students;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.mentors = mentors;
        this.students = students;
        List<int[]> list = new ArrayList<>();
        backtrack(list, new boolean[students.length]);
        return max;
    }

    public void backtrack(List<int[]> list, boolean[] used) {
        if (list.size() == mentors.length) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length; j++) {
                    if (list.get(i)[j] == mentors[i][j])
                        cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }
        for (int i = 0; i < students.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.add(students[i]);
            backtrack(list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
