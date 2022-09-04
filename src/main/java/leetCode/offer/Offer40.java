package leetCode.offer;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-11-21 11:40 下午
 */
public class Offer40 {

    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        System.out.println(Arrays.toString(offer40.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[]{};
        }
        int index = helper(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, index);
    }

    public static int helper(int[] a, int lo, int hi, int k) {
        int pi = a[lo];
        int low_temp = lo;
        int hi_temp = hi;
        while (lo < hi) {
            while (lo < hi && a[hi] >= pi) {
                hi--;
            }
            a[lo] = a[hi];
            while (lo < hi && a[lo] <= pi) {
                lo++;
            }
            a[hi] = a[lo];
        }
        a[lo] = pi;
        if (lo == k) {
            return lo;
        } else if (lo > k) {
            return helper(a, low_temp, lo - 1, k);
        } else {
            return helper(a, lo + 1, hi_temp, k);
        }
    }
}
