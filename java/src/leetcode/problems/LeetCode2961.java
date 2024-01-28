package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 16:37
 */
public class LeetCode2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            long a = variables[i][0];
            long b = variables[i][1];
            long c = variables[i][2];
            long m = variables[i][3];
            long t = 1;
            for (int j = 0; j < b; j++) {
                t = (t * a) % 10;
            }
            long tt = 1;
            for (int j = 0; j < c; j++) {
                tt = (tt * t) % m;
            }
            if (tt % m == target) {
                res.add(i);
            }
        }
        return res;
    }
}
