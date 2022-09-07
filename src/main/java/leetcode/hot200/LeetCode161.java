package leetcode.hot200;

/**
 * @author jingxinwu
 * @date 2022-01-25 11:38 PM
 */
public class LeetCode161 {

    /**
     * 给定两个字符串s 和 t，判断他们的编辑距离是否为 1。
     *
     * 注意：
     *
     * 满足编辑距离等于 1 有三种可能的情形：
     *
     * 往 s中插入一个字符得到 t
     * 从 s中删除一个字符得到 t
     * 在 s中替换一个字符得到 t
     * 示例 1：
     *
     * 输入: s = "ab", t = "acb"
     * 输出: true
     * 解释: 可以将 'c' 插入字符串 s来得到 t。
     * 示例 2:
     *
     * 输入: s = "cab", t = "ad"
     * 输出: false
     * 解释: 无法通过 1 步操作使 s 变为 t。
     * 示例 3:
     *
     * 输入: s = "1203", t = "1213"
     * 输出: true
     * 解释: 可以将字符串 s中的 '0' 替换为 '1' 来得到 t。
     **/

    public boolean isOneEditDistance(String s, String t) {

        int ns = s.length();
        int nt = t.length();

        // Ensure that s is shorter than t.
        if (ns > nt) {
            return isOneEditDistance(t, s);
        }

        // The strings are NOT one edit away distance
        // if the length diff is more than 1.
        if (nt - ns > 1) {
            return false;
        }

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // if strings have the same length
                if (ns == nt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    // if strings have different lengths
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        // If there is no diffs on ns distance
        // the strings are one edit away only if t has one more character.
        return (ns + 1 == nt);
    }

}
