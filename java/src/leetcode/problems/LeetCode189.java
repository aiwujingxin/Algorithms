package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:42
 */
public class LeetCode189 {

    public void rotate(int[] a, int k) {
        int n = a.length;
        k %= n;
        if (k == 0) return;
        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
    }

    void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
}
