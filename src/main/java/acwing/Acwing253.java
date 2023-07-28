package acwing;


import basic.advstructure.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 00:26
 */
public class Acwing253 {

    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            TreapTree tree = new TreapTree();
            tree.build();
            while (n-- > 0) {
                int opt = in.nextInt();
                int op = in.nextInt();
                if (opt == 1)
                    tree.insert(op);
                else if (opt == 2)
                    tree.remove(op);
                else if (opt == 3)
                    System.out.println(tree.getRangByKey(op) - 1);
                else if (opt == 4)
                    System.out.println(tree.getKeyByRang(op + 1));
                else if (opt == 5)
                    System.out.println(tree.getPre(op));
                else
                    System.out.println(tree.getNext(op));
            }

        }
    }

}
