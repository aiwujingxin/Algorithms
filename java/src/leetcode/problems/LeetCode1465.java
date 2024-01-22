package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:37
 */
public class LeetCode1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        redixSort(horizontalCuts);
        redixSort(verticalCuts);
        long a = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long b = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            a = Math.max(a, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            b = Math.max(b, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) ((a * b) % 1000000007);
    }

    private void redixSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] temp = new int[nums.length];
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            int[] count = new int[10];
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int index = (nums[i] / exp) % 10;
                temp[count[index] - 1] = nums[i];
                count[index]--;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }
}
