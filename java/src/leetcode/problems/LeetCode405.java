package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 18:04
 */
public class LeetCode405 {

    public String toHex(int num) {
        String[] strs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuilder sb = new StringBuilder();
        long lnum = num;
        if (num < 0) {
            lnum = (long) (Math.pow(2, 32) + num);
        }
        while (lnum > 15) {
            sb.append(strs[(int) (lnum % 16)]);
            lnum = lnum / 16;
        }
        sb.append(strs[(int) lnum]);
        return sb.reverse().toString();
    }
}

