package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/12 16:26
 */
public class LeetCode536 {

    public static void main(String[] args) {
        System.out.println(new LeetCode536().findRIndex("-4(2(3)(1))(6(5)(7))"));
        System.out.println(new LeetCode536().str2tree("-1"));
        System.out.println(new LeetCode536().getValue("-1"));
        System.out.println(new LeetCode536().getValue("-2313"));
    }

    //4(2(3)(1))(6(5)(7))
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int v = getValue(s);
        TreeNode root = new TreeNode(v);

        int L = findLIndex(s);

        int R = findRIndex(s);
        if (L < R) {
            root.left = str2tree(s.substring(L + 1, R));
        }
        if (R + 2 < s.length()) {
            root.right = str2tree(s.substring(R + 2, s.length() - 1));
        }
        return root;
    }


    private int getValue(String s) {
        boolean flag = false;
        int start = 0;
        int end = 0;
        if (s.charAt(0) == '-') {
            start = 1;
            end = 1;
            flag = true;
        }
        while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
            end++;
        }
        return flag ? -1 * Integer.parseInt(s.substring(start, end)) : Integer.parseInt(s.substring(start, end));
    }

    public int findLIndex(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int index = 0;

        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                break;
            }
            index++;
        }
        return index;
    }

    public int findRIndex(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int index = 0;
        int left = 0;
        int right = 0;
        while (index < s.length()) {

            if (s.charAt(index) == '(') {
                left++;
            } else if (s.charAt(index) == ')') {
                right++;
            } else {
                index++;
                continue;
            }
            if (left == right) {
                break;
            }
            index++;
        }
        return index;
    }
}
