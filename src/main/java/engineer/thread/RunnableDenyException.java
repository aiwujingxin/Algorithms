package engineer.thread;

/**
 * @author jingxinwu
 * @date 2022-02-24 7:09 PM
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String msg) {
        super(msg);
    }
}