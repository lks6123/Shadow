package com.tencent.shadow.sample.plugin.app.lib;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.shadow.sample.host.lib.PluginBridgeHolder;
import com.tencent.shadow.sample.host.lib.ShadowHelper;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.btn_jump_anther).setOnClickListener(v -> {
            ShadowHelper shadowHelper = PluginBridgeHolder.getBridge().<ShadowHelper>getHostData("ShadowHelper");
            if (shadowHelper != null) {
                shadowHelper
                        .startActivity(
                                "sample-plugin-app",
                                "com.tencent.shadow.sample.plugin.app.lib.Test2Activity"
                        );
            }
        });
    }
}