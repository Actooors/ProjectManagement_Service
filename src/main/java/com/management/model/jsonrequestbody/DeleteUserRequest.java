package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 批量删除用户前端请求Json
 * @author: xw
 * @create: 2019-05-10 23:28
 */
@Data
public class DeleteUserRequest {
    private List<String> userId;
}
