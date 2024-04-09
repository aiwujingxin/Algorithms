package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/12 21:51
 */
public class LeetCode852 {

    //https://leetcode.cn/problems/peak-index-in-a-mountain-array/solution/gong-shui-san-xie-er-fen-san-fen-cha-zhi-5gfv/

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid - 1] >= arr[mid]) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
