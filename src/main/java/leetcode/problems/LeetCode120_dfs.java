package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 14:02
 */
public class LeetCode120_dfs {

    //https://leetcode.com/problems/triangle/discuss/2564002/Java-dfs-%2B-memo-but-super-simple

    List<List<Integer>> list;
    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        list = triangle;
        memo = new Integer[list.size()][list.size()];
        return dfs(0, 0);
    }

    int dfs(int index, int loc) {
        if (index == list.size()) {
            return 0;
        }

        if (memo[index][loc] == null) {
            memo[index][loc] = list.get(index).get(loc) +
                    Math.min(dfs(index + 1, loc),
                            dfs(index + 1, loc + 1));
        }
        return memo[index][loc];
    }
}
