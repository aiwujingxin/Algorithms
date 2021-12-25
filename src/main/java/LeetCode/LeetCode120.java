package LeetCode;

import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-10 1:39 下午
 */
public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur.set(j, Math.min(triangle.get(i + 1).get(j + 1),
                        triangle.get(i + 1).get(j)) + cur.get(j));
            }
        }
        return triangle.get(0).get(0);
    }

}
