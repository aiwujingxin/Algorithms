package basic.engineer.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:13 PM
 */
public class MainTest {

    public static void main(String[] args) {
        final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 100);
        for (int i = 0; i <= 20; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "开始了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
