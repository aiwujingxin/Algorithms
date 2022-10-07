package codeTop.ms;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2022-02-16 4:46 PM
 */
public class LeetCode179 {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsToWord = new String[n];
        for (int i = 0; i < n; i++) {
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //fix
        //有思路，但是具体的排序没写出来
        Arrays.sort(numsToWord, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();

        for (String s : numsToWord) {
            sb.append(s);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;

    }


}
