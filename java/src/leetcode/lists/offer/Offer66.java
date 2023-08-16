package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-27 3:07 下午
 */
public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        //其实本质就是两个dp数组，分别维护 i 左侧、右侧的乘积和。楼主这里是省去了O(n)的空间
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

}
