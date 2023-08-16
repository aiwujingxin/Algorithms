package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/3 18:50
 */
public class LeetCode157 {

    public int read(char[] buf, int n) {
        int idx = 0;
        char[] buf4 = new char[4];
        int size = read4(buf4);
        while (size > 0 && idx < n) {
            for (int i = 0; i < size && idx < n; ++i) buf[idx++] = buf4[i];
            size = read4(buf4);
        }
        return idx;
    }

    private int read4(char[] buf4) {
        return 0;
    }
}
