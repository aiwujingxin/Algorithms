package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/3 22:11
 */
public class LeetCode2107 {

    public static void main(String[] args) {
        System.out.println(new LeetCode2107().shareCandies(new int[]{1, 2, 2, 3, 4, 3}, 3));
        System.out.println(new LeetCode2107().shareCandies(new int[]{2, 2, 2, 2, 3, 3}, 2));
        System.out.println(new LeetCode2107().shareCandies(new int[]{2, 4, 5}, 0));
    }

    public int shareCandies(int[] candies, int k) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> origin = new HashMap<>();
        for (int candy : candies) {
            origin.put(candy, origin.getOrDefault(candy, 0) + 1);

        }

        int total = origin.size();

        if (k == 0) {
            return total;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        int ans = 0;
        int left = 0;
        int right = 0;

        while (right < candies.length) {
            map.put(candies[right], map.getOrDefault(candies[right], 0) + 1);
            if (Objects.equals(map.get(candies[right]), origin.get(candies[right]))) {
                count++;
            }
            if (right - left + 1 > k && left < right) {
                if (Objects.equals(map.get(candies[left]), origin.get(candies[left]))) {
                    count--;
                }
                map.put(candies[left], map.get(candies[left]) - 1);

                if (map.get(candies[left]) == 0) {
                    map.remove(candies[left]);
                }
                left++;
            }
            if (right - left + 1 == k) {
                ans = Math.max(ans, total - count);
            }
            right++;
        }
        return ans;
    }
}
