package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-24 10:32 下午
 */
public class LeetCode56 {

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(leetCode56.merge(arr)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int[] temp = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(temp);
        for (int i = 1; i < intervals.length; i++) {
            int[] target = intervals[i];
            //相离
            if (target[0] > temp[1]) {
                list.add(target);
                temp = target;
            } else {// 相交
                int[] newInt = new int[2];
                newInt[0] = temp[0];
                newInt[1] = Math.max(target[1], temp[1]);
                list.remove(list.size() - 1);
                list.add(newInt);
                temp = newInt;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
