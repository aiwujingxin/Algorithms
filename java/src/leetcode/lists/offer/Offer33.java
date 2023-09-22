package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 01:49
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    public boolean check(int[] postorder, int start, int end) {
        if (start > end) {
            return true;
        }
        if (start == end) {
            return true;
        }
        int root = postorder[end];
        int index = end - 1;
        while (index > start && postorder[index] > root) {
            index--;
        }
        if (index > start) {
            // 剩下的都要比root小
            for (int i = start; i <= index; i++) {
                if (postorder[i] > root) {
                    return false;
                }
            }
        }
        return check(postorder, start, index) && check(postorder, index + 1, end - 1);
    }
}
