package example.util.concurrent;

/**
 * Created by xuelu
 * 2019/10/23.
 */
public class TestSynchronize {

    private int i;
    private volatile boolean flag;

    public static void main(String[] args) {
        synchronized (TestSynchronize.class) {
            sMethod();
        }
    }

    private synchronized static void sMethod(){
        System.out.println("sMethod");
    }

    public void write(){
        flag = true;
    }

    public void read(){
        if (flag) {
            int a = i;
        }
    }
}
