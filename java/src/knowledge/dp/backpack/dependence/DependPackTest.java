package knowledge.dp.backpack.dependence;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 11:40
 */
public class DependPackTest {

    public static void main(String[] args) {
        System.out.println(2200 == new DependPack_dp().backPack(new int[][]{
                {800, 2, 0},
                {400, 5, 1},
                {300, 5, 1},
                {400, 3, 0},
                {500, 2, 0}}, 1000, 5));
        System.out.println(6594 == new DependPack_dp().backPack(new int[][]{
                {800, 2, 0},
                {400, 5, 1},
                {300, 5, 1},
                {40, 3, 0},
                {500, 2, 0},
                {300, 3, 2},
                {99, 3, 2},
                {500, 2, 0},
                {300, 3, 2},
                {99, 3, 2},
        }, 2000, 10));
    }
}
