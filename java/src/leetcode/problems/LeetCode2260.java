package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/3 21:39
 */
public class LeetCode2260 {

    public int minimumCardPickup(int[] cards) {
        if (cards == null || cards.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = cards.length + 1;
        while (right < cards.length) {
            map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);
            if (map.get(cards[right]) == 2) {
                while (map.size() < right - left + 1) {
                    map.put(cards[left], map.get(cards[left]) - 1);
                    if (map.get(cards[left]) == 0) {
                        map.remove(cards[left]);
                    }
                    left++;
                }
                ans = Math.min(ans, right - left + 2);
            }

            right++;
        }
        return ans == cards.length + 1 ? -1 : ans;
    }
}
