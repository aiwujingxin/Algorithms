package leetcode.topinterview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 13:23
 */
public class LeetCode179 {
    //copy
    //https://www.youtube.com/watch?v=LUxREjEADCw&t=215s
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsToWord = new String[n];
        for (int i = 0; i < n; i++) {
            numsToWord[i] = String.valueOf(nums[i]);
        }
        // 7 8
        Arrays.sort(numsToWord, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //      87                  78
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();

        for (String s : numsToWord) {
            sb.append(s);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
