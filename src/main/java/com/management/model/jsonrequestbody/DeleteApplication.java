package com.management.model.jsonrequestbody;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @program: management
 * @description: 用户撤销自己的申请
 * @author: ggmr
 * @create: 2018-12-25 19:30
 */
@Data
public class DeleteApplication {
    private Integer applicationId;
    private String applicationName;
}
