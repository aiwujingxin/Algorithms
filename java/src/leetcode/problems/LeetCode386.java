package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 22:12
 */
public class LeetCode386 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return ans;
    }

    void dfs(int cur, int limit) {
        if (cur > limit) {
            return;
        }
        ans.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i, limit);
        }
    }

    public List<Integer> lexicalOrder_v1(int n) {
        List<Integer> rets = new ArrayList<>();
        rets.add(1);
        int i = 1;

        while (rets.size() < n) {
            if (i * 10 <= n) {
                i = i * 10;
            } else {
                while (i + 1 > n || (i % 10 == 9)) {
                    i = i / 10;
                }
                i += 1;
            }
            rets.add(i);
        }
        return rets;
    }
}
