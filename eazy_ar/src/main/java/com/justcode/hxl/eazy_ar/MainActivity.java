package com.justcode.hxl.eazy_ar;

import java.util.ArrayList;
import java.util.List;



import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baidu.ar.util.ARLog;
import com.justcode.hxl.eazy_ar.utils.AssetsCopyToSdcard;

public class MainActivity extends Activity {
    private String[] mArName;
    private String[] mArDesciption;
    private ListView mListView;
    private ArrayAdapter mAdapter;
    private List<ListItemBean> mListData;

    public static final String ASSETS_CASE_FOLDER = "ardebug";
    public static final String DEFAULT_PATH =
            Environment.getExternalStorageDirectory().toString() + "/" + ASSETS_CASE_FOLDER;

    // 权限请求相关
    private static final String[] ALL_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    private static final int REQUEST_CODE_ASK_ALL_PERMISSIONS = 154;
    private boolean mIsDenyAllPermission = false;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        ARLog.setDebugEnable(true);
        initData();
        initView();
    }

    private void initData() {
//        Resources res = getResources();
//        mArName = res.getStringArray(R.array.ar_name);
//        mArDesciption = res.getStringArray(R.array.ar_description);
    }

    private void initView() {
//        mListData = getListItemData();
//        mListView = (ListView) findViewById(R.id.demo_list);
//        mListView.addFooterView(new ViewStub(this));
//        mAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mArName);
//        mListView.setAdapter(mAdapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                intent = new Intent(MainActivity.this, IntroActivity.class);
//                Bundle bundle = new Bundle();
//                ListItemBean listItemBean = mListData.get(position);
//                bundle.putString("ar_key", listItemBean.getARKey());
//                bundle.putInt("ar_type", listItemBean.getARType());
//                bundle.putString("ar_path", listItemBean.getARPath());
//                bundle.putString("name", listItemBean.getName());
//                bundle.putString("description", listItemBean.getDescription());
//                intent.putExtras(bundle);
//                // 拷贝文件到SD卡
//                if (!TextUtils.isEmpty(listItemBean.getARPath())) {
//                    requestAllPermissions(REQUEST_CODE_ASK_ALL_PERMISSIONS);
//                } else {
//                    startActivity(intent);
//                }
//            }
//        });
    }

    private List<ListItemBean> getListItemData() {
        List<ListItemBean> list = new ArrayList<>();

        // 加载本地AR内容
        list.add(new ListItemBean(5, "", DEFAULT_PATH));
        // SLAM AR 小熊
        list.add(new ListItemBean(5, "您创建的AR内容的AR Key", ""));
        // 本地识图
        list.add(new ListItemBean(6, "", ""));
        // 云端识图
        list.add(new ListItemBean(7, "", ""));
        // Track AR城市地图case
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // IMU AR 请财神case
        list.add(new ListItemBean(8, "您创建的AR内容的AR Key", ""));
        // 语音
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // TTS
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // 滤镜
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // LOGO识别
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // 手势识别
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // 在线视频
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));
        // 背景分割
        list.add(new ListItemBean(0, "您创建的AR内容的AR Key", ""));

        if (mArName != null && mArDesciption != null) {
            for (int i = 0; i < mArName.length && i < mArDesciption.length; i++) {
                list.get(i).setName(mArName[i]);
                list.get(i).setDescription(mArDesciption[i]);
            }
        }
        return list;
    }

    private class ListItemBean {
        String mARKey;
        int mARType;
        String mName;
        String mDescription;
        String mARPath;

        ListItemBean(int arType, String arKey, String arPath) {
            this.mARType = arType;
            this.mARKey = arKey;
            this.mARPath = arPath;
        }

        public String getARKey() {
            return mARKey;
        }

        public int getARType() {
            return mARType;
        }

        public String getARPath() {
            return mARPath;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
        }
    }


    /**
     * 请求权限
     *
     * @param requestCode
     */
    private void requestAllPermissions(int requestCode) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                List<String> permissionsList = getRequestPermissions(this);
                if (permissionsList.size() == 0) {
                    // 权限已申请成功 进行资源Copy
                    AssetsCopyToSdcard assetsCopyTOSDcard = new AssetsCopyToSdcard(MainActivity.this);
                    assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH);
                    startActivity(intent);
                    return;
                }
                if (!mIsDenyAllPermission) {
                    requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                            requestCode);
                }
            } else {
                // 5.0及以下直接进行数据的Copy
                AssetsCopyToSdcard assetsCopyTOSDcard = new AssetsCopyToSdcard(MainActivity.this);
                assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_ASK_ALL_PERMISSIONS) {
            mIsDenyAllPermission = false;
            for (int i = 0; i < permissions.length; i++) {
                if (i >= grantResults.length || grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    mIsDenyAllPermission = true;
                    break;
                }
            }
            // 权限申请成功 进行资源Copy
            AssetsCopyToSdcard assetsCopyTOSDcard = new AssetsCopyToSdcard(MainActivity.this);
            assetsCopyTOSDcard.assetToSD(ASSETS_CASE_FOLDER, DEFAULT_PATH);
            startActivity(intent);
            if (mIsDenyAllPermission) {
                finish();
            }
        }

    }

    private static List<String> getRequestPermissions(Activity activity) {
        List<String> permissionsList = new ArrayList();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : ALL_PERMISSIONS) {
                if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                    permissionsList.add(permission);
                }
            }
        }
        return permissionsList;
    }
}