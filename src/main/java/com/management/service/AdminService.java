package com.management.service;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.OV.Result;
import com.management.model.entity.ProjectCategory;
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

    Result CreateProjectCategory(ProjectCategoryInfo projectCategoryInfo);
}
