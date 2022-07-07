package com.tencent.shadow.sample.host.lib;

public interface PluginBridge {
    public <T> T getHostData(String key);

    public <T> void addHostData(String key, T data);
}
