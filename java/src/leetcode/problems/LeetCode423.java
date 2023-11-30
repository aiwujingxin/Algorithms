package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 10:44
 */
public class LeetCode423 {

    public String originalDigits(String s) {
        int[] nums = new int[10];
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        nums[0] = count['z' - 'a'];
        nums[2] = count['w' - 'a'];
        nums[4] = count['u' - 'a'];
        nums[6] = count['x' - 'a'];
        nums[8] = count['g' - 'a'];

        nums[3] = count['h' - 'a'] - nums[8];
        nums[5] = count['f' - 'a'] - nums[4];
        nums[7] = count['s' - 'a'] - nums[6];

        nums[1] = count['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[9] = count['i' - 'a'] - nums[5] - nums[6] - nums[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append((char) (i + '0'));
            }
        }
        return sb.toString();
    }
}
