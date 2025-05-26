package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 21:41
 */
public class LeetCode13 {

    Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < n && value < map.get(s.charAt(i + 1))) {
                //如果当前值 小于 前一个值，说明这是一个 减法组合（如 IV = 4），需要 减去当前值。
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
