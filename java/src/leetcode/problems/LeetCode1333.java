package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 14:44
 */
public class LeetCode1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] != veganFriendly) {
                continue;
            }
            if (restaurant[3] > maxPrice) {
                continue;
            }
            if (restaurant[4] > maxDistance) {
                continue;
            }
            list.add(restaurant);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i)[0]);
        }
        return res;
    }
}
