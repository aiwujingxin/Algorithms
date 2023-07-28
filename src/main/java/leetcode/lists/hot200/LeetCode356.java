/*
 * @Date: 2023-03-31 23:29:21
 * @LastEditors: Jingxin Wu wujingxinit@outlook.com
 * @LastEditTime: 2023-04-26 13:09:47
 */
package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/17 15:56
 */
public class LeetCode356 {

    public boolean isReflected(int[][] points) {
        //1.首先，遍历数组找到最左和最右的点，以此确定x
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            int j = point[0];
            max = Math.max(j, max);
            min = Math.min(j, min);
        }
        double x = (max + min) / 2.0d;
        //2.确定了预期的x后，用HashSet<List<Integer>存储点所有的点，遍历Set中的所有List是否存在镜像点
        Set<List<Integer>> set = new HashSet<>();
        for (int[] point : points) {
            List<Integer> list = new ArrayList<>();
            list.add(point[0]);
            list.add(point[1]);
            set.add(list);
        }
        //遍历集合
        for (List<Integer> list : set) {
            List<Integer> temp = new ArrayList<>();
            temp.add((int) (2 * x) - list.get(0));
            temp.add(list.get(1));
            if (!set.contains(temp)) {
                return false;
            }
        }
        return true;
    }
}
