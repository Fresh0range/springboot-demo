package org.jzy.demo.mybatis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户编号", required = true, example = "1")
    private Integer id;
    @ApiModelProperty(value = "用户名", required = true, example = "zhang san")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
