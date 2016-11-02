package com.rd.common.rdenum;

/**
 * Created by wanglimin1 on 2016/11/2.
 */
public enum Key {

    /**
     * controller层面的监控前缀
     */
    CONTROLLER("controller"),

    /**
     * 业务逻辑的监控前缀
     */
    SERVICE("service"),

    /**
     * repository 的监控前缀,表明是从本地资源库获取数据类型的监控前缀
     */
    REPOSITORY("repository"),

    /**
     * 远程调用其他的服务
     */
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
