package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 17:49
 */
public class LeetCode406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
