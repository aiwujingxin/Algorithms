package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/5/25 14:47
 */
public class LeetCode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;
            int idx = i;
            int max = candies[i];
            for (int j = 0; j < candies.length; j++) {
                if (candies[j] > max) {
                    max = candies[j];
                    idx = j;
                }
            }
            res.add(idx == i);
        }
        return res;
    }
}
