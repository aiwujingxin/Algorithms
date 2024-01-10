package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 13:34
 */
public class LeetCode881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int res = 0;
        while (left < right) {
            if (people[left] + people[right] > limit) {
                res++;
                right--;
            } else {
                left++;
                right++;
                res++;
            }

        }
        return res;
    }
}
