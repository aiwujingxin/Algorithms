package knowledge.dp.statedp;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/3 23:22
 */
public class AcWing92 {

    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 0; i < 1 << n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = i >> j;
                    if ((t & 1) == 1)
                        System.out.print(j + 1 + " ");
                }
                System.out.println();
            }
        }
    }
}
