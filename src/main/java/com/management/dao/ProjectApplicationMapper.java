package com.management.dao;

import com.management.model.entity.ProjectApplication;
import com.management.model.entity.ProjectApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectApplicationMapper {
    int countByExample(ProjectApplicationExample example);

    int deleteByExample(ProjectApplicationExample example);

    int deleteByPrimaryKey(String projectApplicationId);

    int insert(ProjectApplication record);

    int insertSelective(ProjectApplication record);

    List<ProjectApplication> selectByExample(ProjectApplicationExample example);

    ProjectApplication selectByPrimaryKey(String projectApplicationId);

    int updateByExampleSelective(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByExample(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByPrimaryKeySelective(ProjectApplication record);

    int updateByPrimaryKey(ProjectApplication record);

    //用户查找已经申请的项目
    List<ProjectApplication> selectMyApplication(String userId);

    //包含任务书阶段被驳回和其他任何申请阶段被驳回的项目
    List<ProjectApplication> selectFailProjectApplication(String userId);

    List<ProjectApplication> queryAllProgressAndFailProject(String userId);

    //领导查看所有自己负责的项目申请
    List<ProjectApplication> selectAllProjectApplication(String leaderId);
}