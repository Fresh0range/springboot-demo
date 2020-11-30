package org.jzy.demo.jpa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@ApiModel(value = "用户实体类")
@Data
@Entity
@Table
public class User {
    @ApiModelProperty(value = "用户编号", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "用户名", required = true, example = "zhang san")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
