package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 21:36
 * @link <a href="https://www.youtube.com/watch?v=jB-579GCoIk"></a>
 */
public class LeetCode400 {

    public int findNthDigit(int n) {
        int start = 1;
        int digitNum = 1;
        long base = 9;

        while (n > digitNum * base) {
            n -= (int) (digitNum * base);
            start *= 10;
            base *= 10;
            digitNum++;
        }

        start += (n - 1) / digitNum;

        String s = String.valueOf(start);
        char c = s.charAt((n - 1) % digitNum);

        return c - '0';
    }
}

