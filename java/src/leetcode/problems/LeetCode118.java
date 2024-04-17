package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 16:12
 */
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 1; j < i; j++) {
                list.add(last.get(j - 1) + last.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
