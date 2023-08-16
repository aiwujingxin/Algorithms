package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/14 18:10
 */
public class LeetCode1156 {

    //https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/solution/bi-jiao-jian-dan-de-jie-ti-fang-fa-by-ji-siie/

    public static void main(String[] args) {
        System.out.println(new LeetCode1156().maxRepOpt1("aaabaaa"));
    }

    public int maxRepOpt1(String text) {
        int[] cntTotal = new int[26];
        for (char ch : text.toCharArray()) {
            cntTotal[ch - 'a'] += 1;
        }
        int[] cnt = new int[26];
        int ans = 0, maxCount = 0, right = 0, left = 0;
        while (right < text.length()) {
            int idx = text.charAt(right) - 'a';
            cnt[idx]++;
            if (cntTotal[idx] - 1 > maxCount) {
                maxCount = Math.max(maxCount, cnt[idx]);
            }
            while (right - left + 1 > maxCount + 1) {
                cnt[text.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
