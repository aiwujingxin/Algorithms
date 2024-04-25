package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 01:00
 * @description 我们可以先构建ab ab ab...ab ab，然后将多余的a，往每个ab段之间分别插入。还有更多的的a的话（最多两个）就再加在最后。
 */
public class LeetCode984 {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        if (A > B) {
            int diff = A - B;
            for (int i = 0; i < B; i++) {
                sb.append('a');
                if (diff > 0) {
                    sb.append('a');
                    diff--;
                }
                sb.append('b');
            }
            for (int i = 0; i < diff; i++) {
                sb.append('a');
            }
        } else {
            int diff = B - A;
            for (int i = 0; i < A; i++) {
                sb.append('b');
                if (diff > 0) {
                    sb.append('b');
                    diff--;
                }
                sb.append('a');
            }
            for (int i = 0; i < diff; i++) {
                sb.append('b');
            }
        }
        return sb.toString();
    }
}
