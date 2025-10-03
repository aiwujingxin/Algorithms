package leetcode.interview;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 02:34
 */
public interface Scheduler {

    /**
     * Submit a job (Runnable) to Scheduler
     * This job will be first invoked after {@code initialDelay} seconds from submission time.
     * If {@code interval} is larger than 0, the job will be repeatedly invoked every {@code interval} seconds
     *
     * @param runnable     The job to run
     * @param initialDelay initial wait time before first invocation (in seconds)
     * @param interval     interval between repeat jobs
     * @return jobId
     */
    String submitJob(Runnable runnable, int initialDelay, int interval);

    /**
     * Return job run result history for a given job, from the first invocation to latest invocation
     *
     * @param jobId The Id of job whose run result history is returned
     * @return Run result history of this job, sorted by startTime from small to large
     */
    List<JobRunResult> getRunResults(String jobId);

    /**
     * Cancel one scheduled job
     * For repeated jobs, cancel all scheduled invocation
     * If one job is running with this method is called, cancel it after this invocation finishes.
     * Do nothing if the job doesn't exist, or it's a finished non-repeated job
     *
     * @param jobId the Id of the job to cancel
     * @return success or not
     */
    boolean cancelJob(String jobId);
}

class JobRunResult {

    private String jobId;
    private boolean success;
    private String message;
    private long startTime;
    private long stopTime;

    // 构造函数
    public JobRunResult(String jobId, boolean success, String message, long startTime, long stopTime) {
        this.jobId = jobId;
        this.success = success;
        this.message = message;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    // Getters
    public String getJobId() {
        return jobId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    @Override
    public String toString() {
        return "JobRunResult{" +
                "jobId='" + jobId + '\'' +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                '}';
    }
}


class MyScheduler implements Scheduler {
    // 内部类，用于封装任务的所有上下文信息
    private static class JobContext {
        final String jobId;
        final Runnable originalRunnable;
        final boolean isPeriodic;
        final AtomicBoolean isCancelled = new AtomicBoolean(false);
        ScheduledFuture<?> future; // 由 ScheduledExecutorService 返回，用于取消

        JobContext(String jobId, Runnable runnable, boolean isPeriodic) {
            this.jobId = jobId;
            this.originalRunnable = runnable;
            this.isPeriodic = isPeriodic;
        }

        void setFuture(ScheduledFuture<?> future) {
            this.future = future;
        }
    }

    // 使用 ScheduledThreadPoolExecutor 作为核心调度引擎
    private final ScheduledExecutorService executorService;
    // 存储任务上下文，使用 ConcurrentHashMap 保证线程安全
    private final Map<String, JobContext> jobs = new ConcurrentHashMap<>();
    // 存储任务执行历史，Value 使用 CopyOnWriteArrayList 以实现高效的读和线程安全的写
    private final Map<String, List<JobRunResult>> history = new ConcurrentHashMap<>();

    public MyScheduler(int corePoolSize) {
        this.executorService = Executors.newScheduledThreadPool(corePoolSize);
    }

    @Override
    public String submitJob(Runnable runnable, int initialDelay, int interval) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable cannot be null.");
        }
        if (initialDelay < 0) {
            throw new IllegalArgumentException("Initial delay cannot be negative.");
        }
        String jobId = UUID.randomUUID().toString();
        boolean isPeriodic = interval > 0;
        JobContext context = new JobContext(jobId, runnable, isPeriodic);
        // 包装原始的 Runnable，以便在执行前后记录结果
        Runnable jobWrapper = () -> {
            // 检查任务是否在计划执行之前被取消
            if (context.isCancelled.get()) {
                return;
            }
            long startTime = Instant.now().getEpochSecond();
            boolean success = false;
            String message = "Success";
            try {
                // 执行真正的任务
                context.originalRunnable.run();
                success = true;
            } catch (Throwable t) {
                // 捕获所有异常，认为是执行失败
                message = t.getMessage();
                System.err.println("Job " + jobId + " failed with exception: " + t.getMessage());
            } finally {
                long stopTime = Instant.now().getEpochSecond();
                JobRunResult result = new JobRunResult(jobId, success, message, startTime, stopTime);
                // 将结果添加到历史记录中
                history.computeIfAbsent(jobId, k -> new CopyOnWriteArrayList<>()).add(result);
                // 如果是非周期性任务，执行完后从 jobs map 中移除
                if (!context.isPeriodic) {
                    jobs.remove(jobId);
                }
            }
        };
        ScheduledFuture<?> future;
        if (isPeriodic) {
            // 对于周期性任务，使用 scheduleAtFixedRate
            future = executorService.scheduleAtFixedRate(jobWrapper, initialDelay, interval, TimeUnit.SECONDS);
        } else {
            // 对于一次性任务，使用 schedule
            future = executorService.schedule(jobWrapper, initialDelay, TimeUnit.SECONDS);
        }
        context.setFuture(future);
        jobs.put(jobId, context);
        return jobId;
    }

    @Override
    public List<JobRunResult> getRunResults(String jobId) {
        List<JobRunResult> results = history.get(jobId);
        if (results == null) {
            return Collections.emptyList();
        }
        // CopyOnWriteArrayList 本身是线程安全的，但返回一个不可修改的视图是更好的实践
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean cancelJob(String jobId) {
        JobContext context = jobs.get(jobId);
        if (context == null) {
            // 任务不存在，或已执行完毕（对于非周期性任务）
            return false;
        }
        // 1. 设置取消标志位。这会阻止未来的执行（在我们的 jobWrapper 中检查）
        context.isCancelled.set(true);
        // 2. 调用 future.cancel() 来从调度队列中移除任务
        // 参数 mayInterruptIfRunning:
        // - true: 如果任务正在运行，尝试中断它（通过 Thread.interrupt()）。
        // - false: 如果任务正在运行，让它运行完毕。
        // 根据接口要求 "cancel it after this invocation finishes"，我们使用 false。
        boolean cancelled = context.future.cancel(false);
        // 3. 从主任务列表中移除
        jobs.remove(jobId);
        return cancelled;
    }

    /**
     * 优雅地关闭调度器，等待正在执行的任务完成。
     */
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个拥有 4 个核心线程的调度器
        MyScheduler scheduler = new MyScheduler(4);

        System.out.println("Submitting jobs at " + Instant.now());

        // 任务1: 一个一次性的任务，5秒后执行
        Runnable task1 = () -> System.out.println("Task 1 (one-time) is running at " + Instant.now());
        String jobId1 = scheduler.submitJob(task1, 5, 0);
        System.out.println("Submitted one-time job with ID: " + jobId1);

        // 任务2: 一个周期性任务，2秒后首次执行，之后每3秒执行一次
        Runnable task2 = () -> System.out.println("--- Task 2 (periodic) is running at " + Instant.now());
        String jobId2 = scheduler.submitJob(task2, 2, 3);
        System.out.println("Submitted periodic job with ID: " + jobId2);

        // 任务3: 一个会失败的任务
        Runnable task3 = () -> {
            System.out.println("Task 3 (failing) is running and will throw exception at " + Instant.now());
            throw new RuntimeException("Something went wrong!");
        };
        String jobId3 = scheduler.submitJob(task3, 4, 0);
        System.out.println("Submitted failing job with ID: " + jobId3);

        // 等待一段时间，让任务执行
        Thread.sleep(10000); // 等待10秒

        // 取消周期性任务2
        System.out.println("\nCancelling job 2...");
        boolean cancelled = scheduler.cancelJob(jobId2);
        System.out.println("Job 2 cancelled: " + cancelled);

        // 再等待一段时间，确保任务2不再执行
        Thread.sleep(5000);

        // 打印所有任务的历史记录
        System.out.println("\n--- Job Histories ---");
        System.out.println("History for Job 1: " + scheduler.getRunResults(jobId1));
        System.out.println("History for Job 2: " + scheduler.getRunResults(jobId2));
        System.out.println("History for Job 3: " + scheduler.getRunResults(jobId3));

        // 关闭调度器
        scheduler.shutdown();
        System.out.println("\nScheduler shut down.");
    }
}
