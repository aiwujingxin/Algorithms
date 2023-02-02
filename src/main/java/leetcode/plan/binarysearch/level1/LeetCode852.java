package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 13:25
 */
public class LeetCode852 {


    public static void main(String[] args) {
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{0, 1, 0}));
        //fix case
        System.out.println(new LeetCode852().peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }

    //[24,69,100,99,79,78,67,36,26,19]  2
    public int peakIndexInMountainArray(int[] arr) {

        if (arr == null || arr.length < 3) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (arr[l] > arr[r]) {
            return l;
        }
        return r;
    }
}
