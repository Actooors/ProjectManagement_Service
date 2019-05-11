package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 修改用户请求Json
 * @author: xw
 * @create: 2019-05-10 23:22
 */
@Data
public class UserStatus {
    private String userId;
    private Integer status;  //1：正常，0：冻结
}
