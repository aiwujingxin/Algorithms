package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:13 PM
 */
public class LeetCode2013 {

    //  y              x         xCount
    Map<Integer, Map<Integer, Integer>> cnt;


    public LeetCode2013() {
        cnt = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        cnt.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> yCnt = cnt.get(y);
        yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0]; //横坐标
        int y = point[1]; //纵坐标
        if (!cnt.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> yCnt = cnt.get(y);
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : cnt.entrySet()) {

            // 纵坐标
            int col = entry.getKey();

            // 横坐标   横坐标次数
            Map<Integer, Integer> colCnt = entry.getValue(); //所有横坐标 和 它的次数
            if (col != y) {
                // 根据对称性，这里可以不用取绝对值
                //边长
                int d = col - y;

                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);

                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
            }
        }
        return res;

    }

}
