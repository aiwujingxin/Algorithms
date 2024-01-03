package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-11-27 2:37 下午
 */
public class LCR187 {

    public int lastRemaining(int n, int m) {
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        helper(list, m, 0);
        return list.get(0);
    }

    private void helper(List<Integer> list, int m, int start) {
        int temp = (m - 1) + start;
        int index = temp % list.size();
        list.remove(index);
        if (list.size() == 1) {
            return;
        }
        helper(list, m, index);
    }

    public int lastRemaining_dp(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
