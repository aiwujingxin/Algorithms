package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:53
 */
public class Offer53_I {

    public static void main(String[] args) {
        System.out.println(new Offer53_I().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = bsearch_1(nums, target);
        int right = bsearch_2(nums, target);
        boolean find = false;
        if (nums[right] == target) {
            find = true;
        }
        if (nums[right] == target) {
            find = true;
        }
        if (!find) {
            return 0;
        }
        return right - left + 1;
    }

    public int bsearch_1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 最后一个小于等于target的数
    public int bsearch_2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
