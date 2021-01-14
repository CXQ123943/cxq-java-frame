package com.steven.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData implements Serializable {

    private Object data;
    private Integer status;
    private String msg;

    public JsonData(Object data) {
        if (data != null) {
            status = 200;
            msg = "success";
        } else {
            status = 500;
            msg = "error";
        }
        this.data = data;
    }
}
