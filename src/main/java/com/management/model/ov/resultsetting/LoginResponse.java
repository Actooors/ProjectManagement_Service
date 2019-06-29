package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: management
 * @description: 登录请求接口返回信息
 * @author: ggmr
 * @create: 2018-07-29 18:28
 */
@Data
public class LoginResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("uid")
    private String userId;
    @JsonProperty("identity")
    private String identity;
}
