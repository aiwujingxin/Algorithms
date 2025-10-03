package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:20
 * @see LeetCode31
 */
public class LeetCode1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;   // 找到第一个下降点
        if (i < 0) return arr; // 已经是最小排列
        // 从右边找第一个比 arr[i] 小的数
        int j = n - 1;
        while (arr[j] >= arr[i] || (j > 0 && arr[j] == arr[j - 1])) j--;
        swap(arr, i, j);
        return arr;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
