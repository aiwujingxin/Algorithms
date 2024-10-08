package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 12:48
 */
public class LCR6 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int find = rightBound(numbers, i + 1, target - numbers[i]);
            if (find != -1 && numbers[find] == target - numbers[i]) {
                return new int[]{i, find};
            }
        }
        return new int[]{};
    }

    private int rightBound(int[] numbers, int start, int num) {
        int left = start;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (numbers[mid] > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
