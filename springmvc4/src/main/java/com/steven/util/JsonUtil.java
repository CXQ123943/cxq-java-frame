package com.steven.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public class JsonUtil {

    public static Map<String, Object> build(Object data, Integer status, String msg) {
        Map<String, Object> result = new HashMap<>(3);
        result.put("data", data);
        result.put("status", status);
        result.put("msg", msg);
        return result;
    }

    public static Map<String, Object> build(Object data) {
        return data == null ? build(null, 500, "err") : build(data, 200, "ok");
    }
}
