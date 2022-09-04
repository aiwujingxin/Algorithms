package leetCode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-11-25 1:05 上午
 */
public class Offer57_2 {


    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                list.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
