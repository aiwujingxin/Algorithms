package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 19:31
 */
public class LeetCode1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new int[]{i, i + j, nums.get(i).get(j)});
                count++;
            }
        }
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
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
