package leetcode.hot200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-26 8:52 PM
 */
public class LeetCode247 {

    /**
     * 中心对称数 II
     * 中心对称数是指一个数字在旋转了180度之后看起来依旧相同的数字（或者上下颠倒地看）。
     * 找到所有长度为 n 的中心对称数。
     * <p>
     * 示例:
     * 输入:  n = 2
     * 输出: ["11","69","88","96"]
     **/

    public static void main(String[] args) {
        System.out.println(new LeetCode247().findStrobogrammatic(4));
    }

    public List<String> findStrobogrammatic(int n) {
        String a = "01689";
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "6", "8", "9"));
        }
        if (n == 2) {
            return new ArrayList<>(Arrays.asList("11", "69", "88", "96"));
        }

        List<String> list = helper(n - 2);
        List<String> res = new ArrayList<>();

        for (String sub : list) {
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("8" + sub + "8");
            res.add("9" + sub + "6");
        }
        return res;

    }

    private List<String> helper(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "6", "8", "9"));
        }
        if (n == 2) {
            return new ArrayList<>(Arrays.asList("11", "69", "88", "96"));
        }
        List<String> subs = helper(n - 2);
        List<String> res = new ArrayList<>();

        for (String sub : subs) {
            res.add("0" + sub + "0");
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("9" + sub + "6");
            res.add("8" + sub + "8");
        }
        return res;
    }
}
