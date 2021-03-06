package com.kfidria.sweethome.helper;

/**
 * Created by kfidria on 04.07.2016.
 */
import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {
    private static final String TAG = ConnectionDetector.class.getSimpleName();

    private Context _context;

    public ConnectionDetector(Context context){
        this._context = context;
    }

    /**
     * Checking for all possible internet providers
     * **/
    public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }
}