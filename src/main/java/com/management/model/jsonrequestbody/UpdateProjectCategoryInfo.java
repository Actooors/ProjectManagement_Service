package com.management.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: management
 * @description: 业务员修改项目大类提交的信息
 * @author: xw
 * @create: 2018-12-18 21:49
 */
@Data
public class UpdateProjectCategoryInfo {

    @JsonProperty("pid")
    private Integer projectCategoryId;

    @JsonProperty("info")
    private ProjectCategoryInfo projectCategoryInfo;
}
