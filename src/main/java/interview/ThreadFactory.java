package interview;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:10 PM
 */
public interface ThreadFactory {


    Thread creatThread(Runnable runnable);

}
