package com.steven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    @Email
    @NotNull
    private String email;

    @NotNull
    @Past
    @DateTimeFormat(pattern="MM-dd yyyy")
    private Date birthday;
}
