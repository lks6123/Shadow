package com.tencent.shadow.sample.host;

import com.tencent.shadow.sample.host.lib.PluginBridge;

import java.util.concurrent.ConcurrentHashMap;

public class PluginBridgeIml implements PluginBridge {
    private final ConcurrentHashMap<String, Object> hostData = new ConcurrentHashMap<>();

    @Override
    public <T> T getHostData(String key) {
        T value = null;
        try {
            value = (T) hostData.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public <T> void addHostData(String key, T data) {
        if (data != null) {
            hostData.put(key, data);
        }
    }
}
