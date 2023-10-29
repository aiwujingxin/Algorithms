package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:01
 */
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        if (numRows == 1) {
            return res;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 1; j < last.size(); j++) {
                level.add(last.get(j) + last.get(j - 1));
            }
            level.add(1);
            res.add(level);
        }
        return res;
    }
}
