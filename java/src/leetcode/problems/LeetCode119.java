package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 16:22
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < i; j++) {
                next.add(list.get(j - 1) + list.get(j));
            }
            next.add(1);
            list = next;
        }
        return list;
    }
}
