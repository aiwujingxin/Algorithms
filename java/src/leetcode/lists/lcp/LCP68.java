package leetcode.lists.lcp;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/5 00:21
 */
public class LCP68 {

    public int beautifulBouquet(int[] flowers, int cnt) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < flowers.length) {
            map.merge(flowers[right], 1, Integer::sum);
            while (map.get(flowers[right]) > cnt) {
                map.merge(flowers[left], -1, Integer::sum);
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}