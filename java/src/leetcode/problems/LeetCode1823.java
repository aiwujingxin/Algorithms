package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 21:33
 * @description 约瑟夫环
 */
public class LeetCode1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            int kill = (cur + k - 1) % list.size();
            list.remove(kill);
            cur = kill % list.size();
        }
        return list.get(0);
    }

    public int findTheWinner_math(int n, int k) {
        if (n <= 1) return n;
        int ans = (findTheWinner(n - 1, k) + k) % n;
        return ans == 0 ? n : ans;
    }
}
