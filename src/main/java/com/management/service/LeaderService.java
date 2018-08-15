package com.management.service;

import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.ov.Result;

/**
 * @program: management
 * @description: 领导层
 * @author: ggmr
 * @create: 2018-07-31 09:33
 */
public interface LeaderService {

    /**
     * @Description: 领导审核一个项目大类
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result isProjectCategoryPassed(IsProjectCategoryPassedPostInfo info);
}
