package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 21:46
 */
public class LeetCode393 {

    public boolean validUtf8(int[] data) {
        int group = 0;

        // 1000 0000
        int mask1 = 1 << 7;
        // 0100 0000
        int mask2 = 1 << 6;

        for (int num : data) {
            if (group == 0) {
                // 开头有几个1
                // 110x xxxx - 1 group
                // 1110 xxxx - 2 group
                // 1111 0xxx - 3 group
                // 1000 0000
                int mask = 1 << 7;
                while ((mask & num) != 0) {
                    group += 1;
                    mask = mask >> 1;
                }

                // 0xxxxxxx 1-byte - valid
                if (group == 0) {
                    continue;
                }

                if (group > 4 || group == 1) {
                    return false;
                }
            } else {
                // 后续表示要以10开头
                if (!((num & mask1) != 0 && (mask2 & num) == 0)) {
                    return false;
                }
            }
            group -= 1;
        }

        return group == 0;
    }
}
