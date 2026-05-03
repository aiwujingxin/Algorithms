package knowledge.datastructure.string.match;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/26 17:17
 */
public class ZAlgorithm implements knowledge.datastructure.string.match.StringMatch {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        // 1. 构造拼接字符串：模式串 + 隔离墙 + 主串
        String s = needle + "#" + haystack;
        int n = s.length();
        int m = needle.length();
        // z[i] 表示 s[i...n-1] 与 s[0...n-1] 的最长公共前缀长度
        int[] z = new int[n];
        // 维护 Z-box [L, R]，表示当前匹配到的最右端的已知领域
        int l = 0, r = 0;
        // i 从 1 开始，因为 z[0] 显然是 n，不需要算
        for (int i = 1; i < n; i++) {
            // 核心优化：如果 i 在已知领域 [L, R] 内，直接抄镜像位置 (i - l) 的作业
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }
            // 暴力扩展：在抄来的保底值基础上，继续向后匹配（如果超出 R，或者本来就不在 R 内）
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            // 更新 Z-box：如果这次匹配突破了历史最右边界 R，则更新结界
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            // 终极目标：如果匹配长度等于 needle 的长度，说明找到了！
            if (z[i] == m) {
                // 减去模式串长度 m 和隔离墙 1，还原在原 haystack 中的真实索引
                return i - m - 1;
            }
        }
        return -1;
    }
}
