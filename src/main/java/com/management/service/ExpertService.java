package com.management.service;

import com.management.model.jsonrequestbody.ExpertJudgeInfo;
import com.management.model.ov.Result;

public interface ExpertService {


    /**
     * @Description: 审核专家通过自身id查询负责的项目申请
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-25
     */
    Result findProjectApplication(String userId);

    /**
     * @Description: 专家审核项目申请并提交审核意见
     * @Param: [projectApplicationId]
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-26
     */
    Result judgeProjectApplication(String userId,ExpertJudgeInfo expertJudgeInfo);
}
