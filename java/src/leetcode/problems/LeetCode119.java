package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:10
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> level = new ArrayList<>();
        level.add(1);
        if (rowIndex == 0) {
            return level;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < level.size(); j++) {
                next.add(level.get(j) + level.get(j - 1));
            }
            next.add(1);
            level = next;
        }
        return level;
    }
}
