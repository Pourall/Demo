package communication;

import android.os.Handler;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 管理负责通信的线程
 */
public class ThreadManager {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void start(String url, String method, JSONObject jsonobj,Handler handler){
               Runnable task = new HttpTread(url, method, jsonobj, handler);
               pool.execute(task);
               pool.shutdown();
    };

}
