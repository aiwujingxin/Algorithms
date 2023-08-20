package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 22:24
 */
public class LeetCode331_degree {

    //https://www.jiakaobo.com/leetcode/331.%20Verify%20Preorder%20Serialization%20of%20a%20Binary%20Tree.html

    public boolean isValidSerialization(String preorder) {
        // 每个非叶子节点都有2出度和1入度, 除了根节点
        // 每个叶子节点都有0出度和1入度
        String[] nodes = preorder.split(",");
        // 让根节点有一个入度
        // degree = outDegree - inDegree
        int degree = 1;
        for (String node : nodes) {
            // 新来一个节点，要消耗一个度
            // 如果此时没有度可以用，那么就返回false
            if (--degree < 0) {
                return false;
            }
            // 如果不是叶子节点，那就要增加两个出度
            if (!node.equals("#")) {
                degree += 2;
            }
        }
        return degree == 0;
    }
}
