package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 19:31
 */
public class LeetCode1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 存储为 [y, val, sum]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                list.add(new int[]{j, row.get(j), i + j});
            }
        }
        list.sort((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[0] - b[0];
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i)[1];
        }
        return result;
    }
}
