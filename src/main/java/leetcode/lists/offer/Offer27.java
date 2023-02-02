package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:37 下午
 */
public class Offer27 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode 节点2 = new TreeNode(2);
        TreeNode 节点7 = new TreeNode(7);

        root.left = 节点2;
        root.right = 节点7;

        TreeNode 节点1 = new TreeNode(1);
        TreeNode 节点3 = new TreeNode(3);

        节点2.left = 节点1;
        节点2.right = 节点3;

        TreeNode 节点6 = new TreeNode(6);
        TreeNode 节点9 = new TreeNode(9);
        节点7.left = 节点6;
        节点7.right = 节点9;

        Offer27 offer27 = new Offer27();
        System.out.println(offer27.mirrorTree(root));
        System.out.println("==");


    }


    //镜像树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;

    }
}
