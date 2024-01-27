package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 11:18
 */
public class LeetCode2501 {

    public int longestSquareStreak(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int max = -1;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited.contains(num)) {
                continue;
            }
            visited.add(num);
            int after = 0;
            int a = num * num;
            while (map.getOrDefault(a, -1) > i && !visited.contains(a)) {
                after++;
                visited.add(a);
                a = a * a;
            }
            int before = 0;
            int b = sqrt(num);
            while (map.getOrDefault(b, -1) > i && !visited.contains(b)) {
                before++;
                visited.add(b);
                b = sqrt(b);
            }
            max = Math.max(max, after + before + 1);
        }
        return max < 2 ? -1 : max;
    }

    public int sqrt(int num) {
        for (int i = 0; i * i <= num; i++) {
            if (i * i == num) {
                return i;
            }
        }
        return -1;
    }
}
