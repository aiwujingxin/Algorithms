package engineer.interview;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-03-08 2:31 PM
 */
public class LevelTree {

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
        A.right = B;
        B.left = C;
        System.out.println(new LevelTree().cal(A));
    }


    public String cal(Node root) {

        if (root == null) {
            return "_";
        }

        List<StringBuilder> list = new ArrayList<>();
        int high = high(root);
        for (int i = 0; i < high; i++) {
            list.add(new StringBuilder());
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty() && level < high) {
            StringBuilder temp = list.get(level);
            int size = q.size();
            while (size > 0) {
                Node cur = q.poll();
                if (cur != null) {
                    temp.append(cur.value);
                    q.offer(cur.left);
                    q.offer(cur.right);
                } else {
                    temp.append("_");
                    if (level + 1 < high) {
                        q.offer(null);
                        q.offer(null);
                    }
                }
                size--;
            }
            level++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder s : list) {
            res.append(s);
        }
        return res.toString();

    }

    private int high(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }

    public String cal_v2(Node root) {
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
