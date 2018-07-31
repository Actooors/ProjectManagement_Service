package com.management.service;
import com.management.model.ov.Result;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import org.springframework.stereotype.Service;

/**
 * @program: management
 * @description: 业务员层的各接口Seriver方法
 * @author: ggmr
 * @create: 2018-07-29 17:22
 */
@Service

public interface AdminService {

    Result createProjectCategory(String userId, ProjectCategoryInfo projectCategoryInfo);
    Result queryProjectCategory(String userId);
}
