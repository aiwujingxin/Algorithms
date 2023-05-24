package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/12 21:51
 */
public class LeetCode852 {

    //https://leetcode.cn/problems/peak-index-in-a-mountain-array/solution/gong-shui-san-xie-er-fen-san-fen-cha-zhi-5gfv/

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
