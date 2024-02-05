package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 15:02
 */
public class LeetCode1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            map.get(path[0] - 1).add(path[1] - 1);
            map.get(path[1] - 1).add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] set = new boolean[5];
            for (int next : map.get(i)) {
                set[ans[next]] = true;
            }
            for (int color = 1; color <= 4; color++) {
                if (!set[color]) {
                    ans[i] = color;
                    break;
                }
            }
        }
        return ans;
    }
}
