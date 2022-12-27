package leetcode.topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 16:53
 */
public class LeetCode324_quicksort {

    //https://leetcode.com/problems/wiggle-sort-ii/solutions/77680/clear-java-o-n-avg-time-o-n-space-solution-using-3-way-partition/

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2};
        int[] arr = new int[]{5, 3, 1, 2, 6, 7, 8, 5, 5};
        new LeetCode324_quicksort().wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void wiggleSort(int[] nums) {
        int median = selectKth(nums, 0, nums.length - 1, nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);
        System.out.println(median);
        System.out.println(Arrays.toString(nums));

        List<Integer> leftArr = new ArrayList<>();
        for (int i = 0; i <= median; i++) {
            leftArr.add(nums[i]);
        }
        List<Integer> rightArr = new ArrayList<>();
        for (int i = median + 1; i < nums.length; i++) {
            rightArr.add(nums[i]);
        }
        System.out.println(leftArr);
        System.out.println(rightArr);
        for (int li = leftArr.size() - 1, ri = rightArr.size() - 1, i = 0; ri >= 0; li--, ri--, i += 2) { // right is same or shorter than left
            nums[i] = leftArr.get(li);
            nums[i + 1] = rightArr.get(ri);
        }
        if (nums.length % 2 != 0) {
            nums[nums.length - 1] = leftArr.get(0);
        }
    }

    private int selectKth(int[] nums, int start, int end, int k) {
        int[] res = partition(nums, start, end);
        int lb = res[0];
        int hb = res[1];
        if (k - 1 < lb) {
            return selectKth(nums, start, lb - 1, k);
        } else if (k - 1 > hb) {
            return selectKth(nums, hb + 1, end, k);
        } else {
            return k - 1;
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int pi = nums[left]; // use random is better in performance
        int index = left;
        while (index <= right) {
            if (nums[index] == pi) {
                index++;
            } else if (nums[index] < pi) {
                swap(nums, index++, left++);
            } else {
                swap(nums, index, right--);
            }
        }
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
