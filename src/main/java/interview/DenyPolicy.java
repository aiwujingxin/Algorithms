package interview;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:10 PM
 */
public interface DenyPolicy {

    void reject(Runnable runnable, ThreadPool threadPool);


    //直接丢弃线程，什么都不做，不通知
    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }

    //抛出异常通知
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("这个线程:" + runnable + " 将会被丢弃");
        }
    }

    //使线程在提交者所在的线程中运行
    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}