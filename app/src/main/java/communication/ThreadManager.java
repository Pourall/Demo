package communication;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池管理负责通信的线程
 */
public class ThreadManager {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void start(String url, String method, Map jsonMap, Handler handler){
               Runnable task = new HttpThread(url, method, jsonMap, handler);
               pool.execute(task);
    };
}
