package com.steven.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @JsonIgnore
    private Long serializableId;

    @JsonProperty("primary-key")
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @DateTimeFormat(pattern="MM-dd yyyy")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="UTC")
    private Date birthday;
}
