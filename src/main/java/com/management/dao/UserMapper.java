package com.management.dao;

import com.management.model.entity.User;
import com.management.model.entity.UserBaseInfo;
import com.management.model.entity.UserExample;
import java.util.List;

import com.management.model.ov.resultsetting.FinalReportInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //根据UserId得到用户基本信息
    UserBaseInfo selectUserInfoByUserId(String userId);

    //查找所有待领导终审的项目
    List<FinalReportInfo> selectFinalProgressByLeaderId(String leader);

}