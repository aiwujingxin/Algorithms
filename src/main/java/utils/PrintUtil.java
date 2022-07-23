package utils;

import java.util.Arrays;

public class PrintUtil {

    public static void print(boolean[][] arr) {
        for (boolean[] booleans : arr) {
            System.out.print(Arrays.toString(booleans));
            System.out.print("  ");
            System.out.println();
        }
    }
}
