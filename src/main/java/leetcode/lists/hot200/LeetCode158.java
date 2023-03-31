package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 23:15
 */
public class LeetCode158 {
    public int ptr = 0;
    int cap = 0;
    char[] temp = new char[4];

    public int read(char[] buf, int n) {
        int res = 0;
        while (res < n) {
            for (; cap > 0 && res < n; cap--) {
                buf[res++] = temp[ptr++];
            }
            if (res == n) {
                return res;
            }
            cap = read4(temp);
            ptr = 0;
            if (cap == 0) {
                return res;
            }
        }
        return res;
    }

    //API
    int read4(char[] buf4) {
        return 0;
    }
}
