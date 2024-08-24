package knowledge.algorithms.dp.backpack.depend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/8/24 16:36
 */
public class Item {


    int v;
    int w;
    List<Integer> children;

    public Item(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public Item() {
        this.children = new ArrayList<>();
        children.add(0);
    }
}
