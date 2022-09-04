package leetCode.problems;

public class LeetCode214_kmp {

    //https://leetcode.cn/problems/shortest-palindrome/solution/tu-jie-kmpsuan-fa-by-yangbingjie/

    public static void main(String[] args) {
        System.out.println(new LeetCode214_kmp().shortestPalindrome("aacecaaa"));
//        System.out.println(new LeetCode214().shortestPalindrome("abcd"));
    }

    public String shortestPalindrome(String s) {
        String kmpstr = s + "#" + new StringBuilder(s).reverse();
        return new StringBuilder(s.substring(kmp(kmpstr))).reverse() + s;
    }

    public int kmp(String kmp) {
        int[] next = new int[kmp.length()];
        int fast = 1;
        int slow = 0;
        while (fast < kmp.length()) {
            if (kmp.charAt(fast) == kmp.charAt(slow)) {
                next[fast] = slow + 1;
                fast++;
                slow++;
            } else if (slow != 0) {
                slow = next[slow - 1];
            } else {
                next[fast++] = 0;
            }
        }
        return next[kmp.length() - 1];
    }
}
