package basicKnowledge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jingxinwu
 * @date 2021-07-02 9:40 下午
 */
public class CMG {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        int zhu = Integer.parseInt(s);
        CMG m = new CMG();

        for (int i = 0; i < zhu; i++) {

            s = scan.nextLine().trim();
            int point = Integer.parseInt(s.split(" ")[0]);
            int bian = Integer.parseInt(s.split(" ")[1]);
            int[][] matrix = new int[point + 1][point + 1];

            for (int j = 0; j < bian; j++) {
                s = scan.nextLine().trim();
                int x = Integer.parseInt(s.split(" ")[0]);
                int y = Integer.parseInt(s.split(" ")[1]);
                matrix[x][y] = 1;
                matrix[y][x] = 1;
            }

            if (m.judge(matrix)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    //找出全相连的点
    private Map<Integer, Integer> find(int[][] matrix) {

        int flag = 1;
        //使用map存放全相连的点
        Map<Integer, Integer> map = new HashMap<>();
        //因为矩阵从1开始存储，所以从1开始遍历
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //默认自身不检查，其他均相连
                if (j != i && matrix[i][j] != 1) {
                    break;
                }
                flag++;
            }
            if (flag == matrix[0].length) {
                map.put(i, 1);
            }
            //flag在循环时应该被清零
            flag = 1;
        }

        return map;
    }

    //判断剩下元素是否存在关联
    private boolean judge(int[][] matrix) {

        CMG m = new CMG();
        Map<Integer, Integer> map;
        map = m.find(matrix);

        for (int i = 0; i < matrix.length; i++) {
            if (!map.containsKey(i)) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (!map.containsKey(j)) {
                        if (matrix[i][j] != 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
