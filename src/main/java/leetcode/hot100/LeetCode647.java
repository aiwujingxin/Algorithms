package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:20
 */
public class LeetCode647 {

    //https://leetcode.com/problems/palindromic-substrings/discuss/2369314/Java-Solution-or-Faster-than-99.99-or-O(n2)

    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int n = c.length, ans = 0;
        for (int i = 0; i < n; i++) {
            // odd-length strings centered at c[i]
            int l = i, r = i;
            while (l >= 0 && r < n && c[l] == c[r]) {
                ans++;
                l--;
                r++;
            }
            //even-length strings centered at c[i] and c[i+1]
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && c[l] == c[r]) {
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
}

