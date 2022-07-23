package LeetCode;

public class LeetCode132_dp_v2 {

    //https://leetcode.com/problems/palindrome-partitioning-ii/discuss/2267479/Runtime%3A-29-ms-faster-than-84.22-of-Java-online-submissions

    public int minCut(String s) {
        int n = s.length();
        // strore the minimum number of cuts at every index
        int[] cuts = new int[n];
        // to check for palindrome
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // max cuts at any index to make it plaindrome  is i
            int min = i;
            for (int j = 0; j <= i; j++) {
                // j==i and (j-i<3)means we dont need to check the boolean dp array
                // if j-i>3 this means we hae to check for j+i element and i-1 element
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    // if j==0 => the string form j->is already a palindrome
                    //otherwise the number of required cuts will be 1+the cuts at index j-1
                    min = Math.min(min, j == 0 ? 0 : 1 + cuts[j - 1]);
                }
            }
            cuts[i] = min;
        }
        // return the total umber of cuts for the entire string at the end
        return cuts[n - 1];
    }
}
