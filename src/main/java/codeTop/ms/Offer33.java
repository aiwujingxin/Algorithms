package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-18 1:24 PM
 */
public class Offer33 {

    public static void main(String[] args) {
        System.out.println(new Offer33().verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }


    boolean recur(int[] postorder, int i, int j) {
        //终止条件： 当i >= j ，说明此子树节点数量≤1 ，无需判别正确性，因此直接返回 true；
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        //划分左子树 和 右子树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
