package app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class CarApp extends Application {
    private static CarApp instance;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mSharedPreferences = getSharedPreferences("application",
                Context.MODE_PRIVATE);
   /* JPushInterface.setDebugMode(true);
    JPushInterface.init(this);  */        // 初始化 JPush
    }

    public static CarApp getInstance() {
        return instance;
    }

    public SharedPreferences getShare() {
        return mSharedPreferences;
    }
}
