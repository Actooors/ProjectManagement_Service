package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 添加或修改用户前端请求Json
 * @author: xw
 * @create: 2019-05-10 23:54
 */
@Data
public class UpdateOrInsertUser {
    private String userName;
    private String userId;
    private String password;
    private List<String> identity;
    private String leader;
}
