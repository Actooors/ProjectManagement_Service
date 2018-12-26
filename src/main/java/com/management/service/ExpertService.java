package com.management.service;

import com.management.model.ov.Result;

public interface ExpertService {
    /**
     * @Description: 通过项目id找到这个项目所有的审核专家对项目的审核状况
     * @Param: [projectId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-1
     */
    Result expertOpinionList(int projectId);

    /**
     * @Description: 审核专家通过自身id查询负责的项目申请
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-25
     */
    Result findProjectApplication(String userId);
}
