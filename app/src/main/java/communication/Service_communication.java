package communication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Fan on 2016/9/2
 */
public class Service_communication extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
