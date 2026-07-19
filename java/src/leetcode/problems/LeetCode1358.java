package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:23
 * <a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/solution/bao-han-suo-you-san-chong-zi-fu-de-zi-zi-fu-chuan-/">...</a>
 */
public class LeetCode1358 {

    public int numberOfSubstrings(String s) {
        return getSubArr(s, 3) - getSubArr(s, 2);
    }

    private int getSubArr(String s, int k) {
        int n = s.length();
        int[] window = new int[3];
        int cnt = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            int c = s.charAt(right) - 'a';
            window[c]++;
            if (window[c] == 1) {
                cnt++;
            }
            while (cnt > k) {
                int d = s.charAt(left) - 'a';
                window[d]--;
                if (window[d] == 0) {
                    cnt--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

    class Solution {
        //https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/solutions/2990226/mo-ban-yue-chang-yue-he-fa-xing-hua-dong-2g7a/
        public int numberOfSubstrings(String S) {
            char[] s = S.toCharArray();
            int ans = 0;
            int left = 0;
            int[] cnt = new int[3];
            for (char c : s) {
                cnt[c - 'a']++;
                while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                    cnt[s[left] - 'a']--;
                    left++;
                }
                ans += left;
            }
            return ans;
        }
    }

    public int numberOfSubstrings_self(String s) {
        int n = s.length();
        int result = 0;

        // 预处理每个位置之后最近的 a, b, c 的位置
        int[] nextA = new int[n];
        int[] nextB = new int[n];
        int[] nextC = new int[n];

        // 初始化，用 n 表示不存在
        int lastA = n, lastB = n, lastC = n;

        // 从右向左遍历，记录每个位置之后最近的 a, b, c 的位置
        for (int i = n - 1; i >= 0; i--) {
            nextA[i] = lastA;
            nextB[i] = lastB;
            nextC[i] = lastC;

            if (s.charAt(i) == 'a') lastA = i;
            else if (s.charAt(i) == 'b') lastB = i;
            else if (s.charAt(i) == 'c') lastC = i;
        }

        // 遍历每个位置作为起始位置
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int farthest = -1;

            if (ch == 'a') {
                // 找最近的 b 和 c
                if (nextB[i] < n && nextC[i] < n) {
                    farthest = Math.max(nextB[i], nextC[i]);
                }
            } else if (ch == 'b') {
                // 找最近的 a 和 c
                if (nextA[i] < n && nextC[i] < n) {
                    farthest = Math.max(nextA[i], nextC[i]);
                }
            } else if (ch == 'c') {
                // 找最近的 a 和 b
                if (nextA[i] < n && nextB[i] < n) {
                    farthest = Math.max(nextA[i], nextB[i]);
                }
            }

            // 如果找到了，从 farthest 到末尾的所有子字符串都满足条件
            if (farthest != -1) {
                result += n - farthest;
            }
        }

        return result;
    }
}
