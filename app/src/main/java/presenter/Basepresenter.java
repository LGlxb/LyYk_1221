package presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import bean.Result;
import core.DataCall;

public abstract class Basepresenter {
    DataCall dataCall;


    public Basepresenter(DataCall dataCall) {
        this.dataCall = dataCall;

    }

    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {

            Result result = (Result) msg.obj;
            if (result.getCode() == 0) {
                dataCall.success(result.getData());
            } else {
                dataCall.fail(result);
            }
        }
    };


    public void requestData(final Object... args) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                Message message = mHandler.obtainMessage();
                message.obj = getData(args);
                mHandler.sendMessage(message);

            }
        }).start();
    }

    protected abstract Result getData(Object... args);

    public void unBindCall() {
        this.dataCall = null;
    }
}
