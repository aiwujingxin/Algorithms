package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 21:36
 * @link <a href="https://www.youtube.com/watch?v=jB-579GCoIk"></a>
 */
public class LeetCode400 {

    public int findNthDigit(int n) {
        n--;
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= (int) (len * 9 * Math.pow(10, len - 1));
            len++;
        }
        int number = (int) Math.pow(10, len - 1) + (n - 1) / len;
        return String.valueOf(number).charAt((n - 1) % len) - '0';
    }
}

