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
            map.put(flowers[right], map.getOrDefault(flowers[right], 0) + 1);
            while (map.get(flowers[right]) > cnt) {
                map.put(flowers[left], map.get(flowers[left]) - 1);
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}