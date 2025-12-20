package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 16:22
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(res.get(j - 1) + res.get(j));
            }
            cur.add(1);
            res = cur;
        }
        return res;
    }

    // C(n,k)=C(n,k−1)×(n−k+1)/k
    public List<Integer> getRow_(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) val);
            val = val * (rowIndex - k) / (k + 1);
        }
        return row;
    }
}
