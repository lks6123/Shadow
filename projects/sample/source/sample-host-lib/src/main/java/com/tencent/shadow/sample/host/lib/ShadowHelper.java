package com.tencent.shadow.sample.host.lib;

import android.os.Bundle;

public interface ShadowHelper {
    default public void startActivity(String partKey, String activityName) {
        startActivity(partKey, activityName, null);
    }

    public void startActivity(String partKey, String activityName, Bundle extra);

}
