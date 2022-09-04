package interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2022-03-08 2:31 PM
 */
public class LevelTreeV1 {

    static class Node {

        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        A.right = B;
        B.left = C;
        C.right = D;
        System.out.println(new LevelTreeV1().cal(A));
    }

    public String cal(Node root) {
        if (root == null) {
            return "_";
        }
        StringBuilder res = new StringBuilder();
        boolean isCanContinue = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && isCanContinue) {
            isCanContinue = false;
            int size = q.size();
            while (size > 0) {
                Node cur = q.poll();
                if (cur != null) {
                    res.append(cur.value);
                    q.offer(cur.left);
                    q.offer(cur.right);
                    if (cur.left != null || cur.right != null) {
                        isCanContinue = true;
                    }
                } else {
                    res.append("_");
                    q.offer(null);
                    q.offer(null);
                }
                size--;
            }
        }
        return res.toString();
    }
}
