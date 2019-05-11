package com.management.model.ov.resultsetting;

import com.management.model.entity.UserBaseInfo;
import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 系统管理员查询所有用户
 * @author: xw
 * @create: 2019-05-11 19:08
 */
@Data
public class AllUserInfo {
    private Integer totalPage;
    private List<UserBaseInfo> userData;
}
