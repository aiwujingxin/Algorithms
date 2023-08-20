package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 17:27
 */
public class LeetCode215_mergesort {

    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {//当拆分到数组当中只要一个值的时候，结束递归
            return;
        }
        int mid = (left + right) / 2;   //找到下次要拆分的中间值
        mergeSort(nums, left, mid, temp);//记录树左边的
        mergeSort(nums, mid + 1, right, temp);//记录树右边的

        //合并两个区间
        //temp就是辅助列表，新列表的需要排序的值就是从辅助列表中拿到的
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;       //给辅助数组里面的值标点
        int j = mid + 1;
        for (int k = left; k <= right; k++) {//k 就为当前要插入的位置
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums[len - k];
    }
}

