package com.test;

import java.util.*;

public class Options {

    public MapProxyObject hash;

    public Options(){
        Map<String,Object> m = new HashMap<String,Object>();
        m.put("tidal","wave");
        this.hash = new MapProxyObject(m);
    }
}
