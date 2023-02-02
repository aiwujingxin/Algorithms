package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 12:40
 */
public class LeetCode374 {


    public static void main(String[] args) {
        System.out.println(new LeetCode374().guessNumber(2126753390));
    }

    static int pick = 1702766719;

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    int guess(int num) {
        return Integer.compare(pick, num);
    }
}
