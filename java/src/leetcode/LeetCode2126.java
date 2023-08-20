package leetcode;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 22:39
 */
public class LeetCode2126 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        if (asteroids == null || asteroids.length == 0) {
            return true;
        }

        Arrays.sort(asteroids);
        long sum = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (sum < asteroids[i]) {
                return false;
            }
            sum += asteroids[i];
        }

        return true;

    }
}
