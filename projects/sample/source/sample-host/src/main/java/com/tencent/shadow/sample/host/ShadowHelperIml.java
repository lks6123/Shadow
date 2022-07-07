package com.tencent.shadow.sample.host;

import android.os.Bundle;
import android.view.View;

import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import com.tencent.shadow.sample.constant.Constant;
import com.tencent.shadow.sample.host.lib.ShadowHelper;
import com.tencent.shadow.sample.host.manager.Shadow;

public class ShadowHelperIml implements ShadowHelper {
    private PluginManager manager = null;

    private static class SingletonHolder {
        public static ShadowHelperIml instance = new ShadowHelperIml();
    }

    private ShadowHelperIml() {
    }

    public static ShadowHelperIml getInstance() {
        return SingletonHolder.instance;
    }

    public PluginManager getManager() {
        if (manager == null) {
            manager = Shadow.getPluginManager(PluginHelper.getInstance().pluginManagerFile);
        }
        return manager;
    }


    @Override
    public void startActivity(String partKey, String activityName, Bundle extra) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.KEY_PLUGIN_ZIP_PATH, PluginHelper.getInstance().pluginZipFile.getAbsolutePath());
        bundle.putString(Constant.KEY_PLUGIN_PART_KEY, partKey);
        bundle.putString(Constant.KEY_ACTIVITY_CLASSNAME, activityName);

        if (extra != null) {
            bundle.putAll(extra);
        }
        getManager().enter(
                HostApplication.getApp().getApplicationContext(),
                Constant.FROM_ID_START_ACTIVITY,
                bundle,
                new EnterCallback() {
                    @Override
                    public void onShowLoadingView(View view) {

                    }

                    @Override
                    public void onCloseLoadingView() {

                    }

                    @Override
                    public void onEnterComplete() {

                    }
                }
        );
    }
}
