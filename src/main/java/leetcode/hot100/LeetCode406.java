package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 13:58
 */
public class LeetCode406 {

    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0) {
            return people;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[2];
                }
                return o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        int[][] res = new int[people.length][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
