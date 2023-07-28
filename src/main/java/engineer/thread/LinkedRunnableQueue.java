package engineer.thread;

import java.util.LinkedList;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:10 PM
 */
public class LinkedRunnableQueue implements RunnableQueue {

    //任务队列的最大容量
    private final int limit;
    //容量最大时，需要使用的拒绝策略
    private final DenyPolicy denyPolicy;
    //存放任务的队列
    private final LinkedList<Runnable> runnableLinkedList;
    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
        runnableLinkedList = new LinkedList<>();
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableLinkedList) {
            //如果缓存数量超过最大值，则使用拒绝策略
            if (runnableLinkedList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                //成功加入list的末尾，并唤醒阻塞中的线程
                runnableLinkedList.addLast(runnable);
                runnableLinkedList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() {
        synchronized (runnableLinkedList) {
            //如果缓存队列为空，则挂起，等待新的任务进来唤醒
            while (runnableLinkedList.isEmpty()) {
                try {
                    runnableLinkedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return runnableLinkedList.removeFirst();
    }

    @Override
    public int size() {
        synchronized (runnableLinkedList) {
            //返回list中的个数
            return runnableLinkedList.size();
        }
    }
}