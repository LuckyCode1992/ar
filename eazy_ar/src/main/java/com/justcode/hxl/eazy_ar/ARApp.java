package com.justcode.hxl.eazy_ar;



import android.app.Application;
import android.util.Log;

import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.util.Res;

public class ARApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("ARAPP","app启动了，并且初始化了AR");
        Res.addResource(this);
        // 设置App Id
        DuMixARConfig.setAppId("14568862");
        // 设置API Key
        DuMixARConfig.setAPIKey("E1GQx86lDVVGpikyadtb1k5y");
        // 设置Secret Key
        DuMixARConfig.setSecretKey("r2iQwdW7UebGIS9Rw7OAp8NTbNo91WhN");
    }
}
