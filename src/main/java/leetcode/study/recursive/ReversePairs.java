package leetcode.study.recursive;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:30 PM
 */
public class ReversePairs {


    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * @author ronaldwu
     * @date 2022-01-31 14:30:57
     **/

    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) {
            return 0;
        }
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}
