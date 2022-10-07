package leetplan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:59
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        int l = 1;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l, r};
            }
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }
}
