package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 16:26
 */
public class LeetCode324_bucketsort {

    public void wiggleSort(int[] nums) {
        //bucket sort
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int big = 0, small = 0;
        if (nums.length % 2 == 0) {//small, big, small, big
            big = nums.length;
            small = big - 1;
        } else {//small, big, small, big, small
            small = nums.length - 1;
            big = small - 1;
        }
        int j = 5000;
        //先放大的
        for (int i = 1; i <= big; i = i + 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        //再放小的
        for (int i = 0; i <= small; i = i + 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }
}
