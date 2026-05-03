package knowledge.datastructure.string.match;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/26 17:30
 */
public class BoyerMoore implements knowledge.datastructure.string.match.StringMatch  {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;

        // 1. 预处理坏字符哈希表 (Bad Character Table)
        // 记录模式串中每个字符【最右侧】出现的位置
        int[] bc = new int[256];
        for (int i = 0; i < 256; i++) {
            bc[i] = -1; // 初始化为 -1，表示未出现过
        }
        for (int i = 0; i < m; i++) {
            // 如果有重复字符，后出现的会覆盖前面的，保证记录的是最右位置
            bc[needle.charAt(i)] = i;
        }

        // 2. 开始滑动匹配
        int i = 0; // i 表示模式串与主串对齐时的最左端位置
        while (i <= n - m) {
            int j = m - 1; // j 从模式串的末尾开始，逆向匹配

            // 从右向左比对字符
            while (j >= 0 && haystack.charAt(i + j) == needle.charAt(j)) {
                j--;
            }

            if (j < 0) {
                // j 穿透了 0，说明模式串全部匹配成功
                return i;
            } else {
                // 发生失配！触发坏字符规则
                // 找到主串中的那个“坏字符”
                char badChar = haystack.charAt(i + j);

                // 计算跳跃距离：失配位置 j - 坏字符在模式串中的最右位置
                int shift = j - bc[badChar];

                // 【核心陷阱】：shift 有可能为负数！
                // 比如主串 "baaa"，模式串 "baaa"，从右向左比，在第一个 'a' 失配
                // 此时坏字符是 'b'，它在模式串的最右位置是 0，j 此时是 1
                // 如果 shift 为负数，说明坏字符在模式串中的位置比当前失配位置还要靠右
                // 此时为了防止模式串向左倒退，强制让它向右滑动 1 步
                i += Math.max(1, shift);
            }
        }
        return -1;
    }
}


