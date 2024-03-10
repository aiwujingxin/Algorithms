package knowledge.algorithms.bitwise;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/8 16:05
 * @description 二进制枚举子集
 */
public class SubSet {

    private static void subset(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    l.add(j);
                }
            }
            list.add(l);
        }
        System.out.println(list);
    }
}
