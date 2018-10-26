package com.justcode.hxl.ar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.justcode.hxl.eazy_ar.ARActivity
import com.justcode.hxl.eazy_ar.utils.AssetsCopyToSdcard
import com.justcode.hxl.permission.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val ASSETS_CASE_FOLDER = "ardebug"
    val DEFAULT_PATH =
            Environment.getExternalStorageDirectory().toString() + "/" + ASSETS_CASE_FOLDER
    companion object {
        var type = 0
        var arkey = "10287922"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_map.setOnClickListener {

            RxPermissions(this).request("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.VIBRAT",
                    "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO"
            ).subscribe {

                val assetsCopyTOSDcard = AssetsCopyToSdcard(this@MainActivity)
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH)
                val intent = Intent()
                intent.putExtra("ar_key","10287922")
                intent.putExtra("ar_type",0)
                intent.setClass(this, ARActivity::class.java)
                startActivity(intent)
            }

        }

        btn_bear.setOnClickListener {

            RxPermissions(this).request("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.VIBRAT",
                    "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO"
            ).subscribe {

                val assetsCopyTOSDcard = AssetsCopyToSdcard(this@MainActivity)
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH)
                val intent = Intent()
                intent.putExtra("ar_key","10287917")
                intent.putExtra("ar_type",0)
                intent.setClass(this, ARActivity::class.java)
                startActivity(intent)
            }

        }

        btn_cat.setOnClickListener {

            RxPermissions(this).request("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.VIBRAT",
                    "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO"
            ).subscribe {

                val assetsCopyTOSDcard = AssetsCopyToSdcard(this@MainActivity)
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH)
                val intent = Intent()
                intent.putExtra("ar_key","10287921")
                intent.putExtra("ar_type",5)
                intent.setClass(this, ARActivity::class.java)
                startActivity(intent)
            }

        }

        btn_dizheng.setOnClickListener {

            RxPermissions(this).request("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.VIBRAT",
                    "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO"
            ).subscribe {

                val assetsCopyTOSDcard = AssetsCopyToSdcard(this@MainActivity)
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH)
                val intent = Intent()
                intent.putExtra("ar_key","10287919")
                intent.putExtra("ar_type",8)
                intent.setClass(this, ARActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
