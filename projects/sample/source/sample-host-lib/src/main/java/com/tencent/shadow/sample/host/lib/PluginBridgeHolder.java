package com.tencent.shadow.sample.host.lib;

public class PluginBridgeHolder {
    private static PluginBridge bridge = null;

    public static void initBridge(PluginBridge bridgeIml) {
        bridge = bridgeIml;
    }

    public static PluginBridge getBridge() {
        return bridge;
    }
}
