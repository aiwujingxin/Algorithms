package leetcode.lists.hot100;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 23:40
 */
public class LeetCode297 {

    static class Codec {

        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
            return rdeserialize(dataList);
        }

        public String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += root.val + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public TreeNode rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);
            return root;
        }
    }
}
