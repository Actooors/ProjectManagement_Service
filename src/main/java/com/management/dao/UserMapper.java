package com.management.dao;

import com.management.model.entity.LeaderInfo;
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

    //查找到专家列表
    List<User> selectExpertInfoList(String identityId);

    //查找领导列表
    List<LeaderInfo> selectLeaderInfoList(String identityId);

    //根据UserId得到用户基本信息
    UserBaseInfo selectUserInfoByUserId(String userId);

    //获取所有用户基本信息
    List<UserBaseInfo> selectAllUserInfo(Integer page);

    //查找所有待领导终审的项目
    List<FinalReportInfo> selectFinalProgressByLeaderId(String leader);

    //领导统计已通过项目数
    Integer countJudgePassProject(String leaderId);

    //领导统计未通过项目数
    Integer countJudgeFailProject(String leaderId);

    //领导统计待初审项目数
    Integer countOneJudgeProject(String leaderId);

    //领导统计待终审项目数
    Integer countFinalJudgeProject(String leaderId);

    //统计各个大类的项目数
    Integer countByProjectType(@Param("leaderId")String leaderId,@Param("type")Integer type);
}