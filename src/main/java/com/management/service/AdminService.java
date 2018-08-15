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


    /**
     * @Description: 查看一个业务员负责的项目大类的列表，返回给他项目大类名字 项目结束时间 和项目结项人数
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result someoneAllProjectCategory(String userId);
}
