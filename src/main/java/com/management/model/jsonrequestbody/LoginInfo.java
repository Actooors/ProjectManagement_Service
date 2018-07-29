package com.management.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: management
 * @description: 登录时向后端请求的数据格式
 * @author: ggmr
 * @create: 2018-07-29 17:25
 */
@Data
public class LoginInfo {
    @JsonProperty("uid")
    private String userId;

    private String password;
}
