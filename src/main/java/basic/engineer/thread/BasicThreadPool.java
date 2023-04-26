package basic.engineer.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:11 PM
 */
public class BasicThreadPool extends Thread implements ThreadPool {

    //初始化线程池的数量
    private final int initSize;
    //线程池最大线程数
    private final int maxSize;
    //线程池核心线程数
    private final int coreSize;
    //当前活跃线程的数量
    private int activeCount;
    //创建线程的工厂
    private final ThreadFactory threadFactory;
    //任务队列
    private final RunnableQueue runnableQueue;
    //线程是否被摧毁
    private volatile boolean isShutdown = false;
    //工作队列
    private final Queue<ThreadTask> internalTasks = new ArrayDeque<>();
    //拒绝策略
    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();
    //看下面，自定义线程工厂
    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
    private final long keepAliveTime;
    private final TimeUnit timeUnit;


    //构造默认线程池时需要传入的参数：初始线程池的数量，最大线程的数量，核心线程数量，任务队列的最大数
    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY, 2, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, int queueSize,
            DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    //初始化线程池并创建initSize个线程
    private void init() {
        //继承了Thread类，初始化时先启动自己
        start();
        IntStream.range(0, initSize).forEach(i -> newThread());
    }

    //创建新的任务线程并启动
    private void newThread() {
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.creatThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        internalTasks.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private void removeThread() {
        ThreadTask threadTask = internalTasks.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("这个线程池已经被销毁了");
        }
        this.runnableQueue.offer(runnable);
    }

    @Override
    public void run() {
        //自动维护线程池
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                isShutdown = true;
                break;
            }
            synchronized (this) {
                if (isShutdown) {
                    break;
                }
                //当任务队列大于0，活跃线程小于核心线程的时候，扩容线程
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    IntStream.range(initSize, coreSize).forEach(i -> newThread());
                    continue;
                }
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    IntStream.range(coreSize, maxSize).forEach(i -> newThread());
                }
                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    IntStream.range(coreSize, activeCount).forEach(i -> removeThread());
                }

            }
        }
    }

    @Override
    public void shutdown() {

    }

    //这一段方法不是特别重要，就有读者自己写
    @Override
    public int getInitSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCoreSize() {
        return 0;
    }

    @Override
    public int getActiveCount() {
        return 0;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    //把线程和internalTask一个组合
    private static class ThreadTask {

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }

        Thread thread;
        InternalTask internalTask;
    }

    private static class DefaultThreadFactory implements ThreadFactory {

        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup group = new ThreadGroup("我的线程-" + GROUP_COUNTER.getAndDecrement());
        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread creatThread(Runnable runnable) {
            return new Thread(group, runnable, "线程池-" + COUNTER.getAndDecrement());
        }
    }
}