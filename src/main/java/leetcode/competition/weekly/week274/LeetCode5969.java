package leetcode.competition.weekly.week274;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2022-01-02 10:36 AM
 */
public class LeetCode5969 {

    public static void main(String[] args) {
        System.out.println(new LeetCode5969().asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 2}));
        System.out.println(new LeetCode5969().asteroidsDestroyed(5, new int[]{4, 9, 23, 4}));
        System.out.println(new LeetCode5969().asteroidsDestroyed(5, new int[]{97}));
        System.out.println(new LeetCode5969().asteroidsDestroyed(195, new int[]{10, 11, 67805}));
        System.out.println(new LeetCode5969().asteroidsDestroyed(10, new int[]{9, 19, 5, 3, 21}));

    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        if (asteroids == null || asteroids.length == 0) {
            return true;
        }

        Arrays.sort(asteroids);

        if (mass < asteroids[0]) {
            return false;
        }

        long temp = mass;
        int i = 0;
        while (i < asteroids.length) {
            if (temp < asteroids[i]) {
                return false;
            }
            temp = temp + asteroids[i];
            i = i + 1;
        }
        return true;
    }

}
