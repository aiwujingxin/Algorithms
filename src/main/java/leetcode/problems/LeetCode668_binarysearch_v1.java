package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 14:05
 */
public class LeetCode668_binarysearch_v1 {


    //涉及元素极多做不到遍历的二维矩阵里的第K小都可以用二分猜答案的套路，转化为“给定一个数，求矩阵中有多少个数比这个数小”，进而实现二分查找，
    // 主站378，719，786，2040题也是类似的思路（其中2040题实现细节极多，代码冗长，导致了rating很高），
    // 第一次见到这类题想不出做法很正常，但这个经典套路还是必须掌握~
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
