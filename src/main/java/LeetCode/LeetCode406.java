package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-12-12 11:29 PM
 */
public class LeetCode406 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LeetCode406().
                reconstructQueue(new int[][]{{7, 1}, {7, 0}})));
    }


    public int[][] reconstructQueue(int[][] array) {
        if (array == null || array.length == 0) {
            return new int[][]{};
        }

        //TODO
        //x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
        //默认为从小到大排序，用参数a减参数b。若需要从大到小排序，则用参数b减参数a
        Arrays.sort(array, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0]; //高到低
            } else {
                return p1[1] - p2[1]; //低到高
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] ints : array) {
            list.add(ints[1], ints);
        }
        return list.toArray(new int[array.length][]);
    }
}
