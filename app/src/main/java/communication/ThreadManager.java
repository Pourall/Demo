package communication;

import android.os.Handler;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import communication.HttpTread; //still need to import even in the same package

/**
 * 管理负责通信的线程
 */
public class ThreadManager {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void start(String url, String method, JSONObject jsonobj,Handler handler){
               Runnable task = new HttpThread(url, method, jsonobj, handler);
               pool.execute(task);
    };

    public static void close(){
	//shutdown the pool
	//plan to be invoked at the termination of the app
    	pool.shutdown();
    }

}
