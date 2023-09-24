package leetcode.lists.LCR;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:40
 */
public class LCR80 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    void backtrack(int start, int n, int k) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}
