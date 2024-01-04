package basic.datastructure.advance;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/4 22:40
 */
public class BinaryIndexedTreeTest {

    public static void main(String[] args) {
        int x = 13;
        while (x > 0) {
            System.out.printf("[%d, %d]\n", x - (x & -x) + 1, x);
            x -= x & -x;
        }
        add(3);
    }

    public static void add(int x) {
        while (x <= 16) {
            System.out.println("更新 " + x);
            x += (x & -x);
        }
    }
}


