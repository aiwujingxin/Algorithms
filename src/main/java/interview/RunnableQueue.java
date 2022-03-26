package interview;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:09 PM
 */
public interface RunnableQueue {

    //新线程进来时,提交任务到缓存队列
    void offer(Runnable runnable);
    //取出线程
    Runnable take();
    //获取队列中线程的数量
    int size();

}
