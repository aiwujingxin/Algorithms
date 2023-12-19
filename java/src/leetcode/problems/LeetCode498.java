package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 10:28
 */
public class LeetCode498 {

    public int[] findDiagonalOrder(int[][] mat) {
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(new int[]{i, i + j, mat[i][j]});
                count++;
            }
        }
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[1] % 2 == 0) {
                    return o2[0] - o1[0];
                }
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] res = new int[count];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i)[2];
        }
        return res;
    }
}
