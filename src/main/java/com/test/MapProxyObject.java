package com.test;

import java.util.Map;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyObject;

public class MapProxyObject implements ProxyObject {
    private final Map<String, Object> values;

    public MapProxyObject(Map<String, Object> map) {
        this.values = map;
    }

    public void putMember(String key, Value value) {
        values.put(key, value.isHostObject() ? value.asHostObject() : value);
    }

    public boolean hasMember(String key) {
        return values.containsKey(key);
    }

    public Object getMemberKeys() {
        return values.keySet().toArray();
    }

    public Object getMember(String key) {
        Object v = values.get(key);
        if (v instanceof Map) {
            return new MapProxyObject((Map<String, Object>)v);
        } else {
            return v;
        }
    }

    public Map<String, Object> getMap() {
        return values;
    }
}