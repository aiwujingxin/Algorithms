package se;

import java.util.Random;

/**
 * @author jingxinwu
 * @date 2022-02-20 1:02 PM
 */
public class FruitGeneratorString implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
