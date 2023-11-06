package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 23:51
 */
public class LeetCode299 {

    public String getHint(String secret, String guess) {
        int[] sArr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            sArr[secret.charAt(i) - '0']++;
        }
        int[] tArr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            tArr[guess.charAt(i) - '0']++;
        }
        int n = secret.length();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                sArr[guess.charAt(i) - '0']--;
                tArr[guess.charAt(i) - '0']--;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(tArr[i], sArr[i]);
        }
        return bull + "A" + cow + "B";
    }
}
