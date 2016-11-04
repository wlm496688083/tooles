package com.rd.common.rdenum;

/**
 * Created by wanglimin1 on 2016/11/2.
 */
public enum Key {

    CONTROLLER("controller"),
    SERVICE("service"),
    REPOSITORY("repository"),
    RPC("rpc"),
    /**
     * 作为服务提供者接口实现的监控前缀
     */
    API("api");

    private String prefix;

    Key(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static String getPrefix(Key key) {
        Key[] values = Key.values();
        for (Key myKey : values) {
            if (myKey == key) {
                return myKey.getPrefix();
            }
        }
        return "";
    }

}
