package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 1/3/26 21:58
 */
public class LeetCode986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (firstList[i][1] < secondList[j][0]) {
                i++;
            } else if (firstList[i][0] > secondList[j][1]) {
                j++;
            } else {
                list.add(new int[]{Math.max(firstList[i][0], secondList[j][0]),
                        Math.min(firstList[i][1], secondList[j][1])});
                if (firstList[i][1] <= secondList[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
