package knowledge.dp.backpack.depend;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 11:40
 */
public class DependPackTest {

    public static void main(String[] args) {
        System.out.println(new DependPack_dp().backPack(new int[][]{
                {800, 2, 0},
                {400, 5, 1},
                {300, 5, 1},
                {400, 3, 0},
                {500, 2, 0}}, 1000, 5));//2200
        System.out.println(new DependPack_treedp().backPack(new int[][]{
                {2, 3, -1},
                {2, 2, 1},
                {3, 5, 1},
                {4, 7, 2},
                {3, 6, 2},
        }, 7, 5)); //11
    }
}
