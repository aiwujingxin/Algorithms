package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/18/25 00:55
 */
public class LeetCode4_bs {

    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int m = A.length, n = B.length, half = (m + n + 1) / 2;
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            int al = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int ar = i == m ? Integer.MAX_VALUE : A[i];
            int bl = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int br = j == n ? Integer.MAX_VALUE : B[j];
            if (al <= br && bl <= ar) {
                return ((m + n) % 2 == 1) ? Math.max(al, bl) : (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
            } else if (al > br) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
