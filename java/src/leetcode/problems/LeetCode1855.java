package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 18:26
 */
public class LeetCode1855 {

    private static int find(int[] nums2, int target) {
        int l = 0;
        int r = nums2.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums2[mid] == target) {
                l = mid;
            } else if (nums2[mid] > target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums2[r] >= target ? r : l;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{100, 20, 10, 10, 5}, 55));
        System.out.println(find(new int[]{100, 20, 10, 10, 5}, 30));
        System.out.println(find(new int[]{100, 20, 10, 10, 5}, 5));
        System.out.println(find(new int[]{100, 20, 10, 10, 5}, 4));
        System.out.println(find(new int[]{100, 20, 10, 10, 5}, 2));
        System.out.println(find(new int[]{10, 10, 1}, 2));
    }

    //[2,2,2]
    //[10,10,1]
    public int maxDistance(int[] nums1, int[] nums2) {
        //在 nums2 中找出比 n 大的最右边的 index
        //比较index 和 i 的关系，并计算
        int res = -1;
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            int index = find(nums2, n);
            if (index < i) {
                continue;
            }
            res = Math.max(index - i, res);
        }
        return res;
    }
}
