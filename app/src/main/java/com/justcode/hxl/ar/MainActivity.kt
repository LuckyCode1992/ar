package com.justcode.hxl.ar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.justcode.hxl.eazy_ar.ARActivity
import com.justcode.hxl.eazy_ar.MainActivity.ASSETS_CASE_FOLDER
import com.justcode.hxl.eazy_ar.MainActivity.DEFAULT_PATH
import com.justcode.hxl.eazy_ar.utils.AssetsCopyToSdcard
import com.justcode.hxl.permission.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        easy_ar.setOnClickListener {

            RxPermissions(this).request("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.VIBRAT",
                    "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO"
            ).subscribe {

                val assetsCopyTOSDcard = AssetsCopyToSdcard(this@MainActivity)
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH)
                val intent = Intent()
                intent.setClass(this, ARActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
