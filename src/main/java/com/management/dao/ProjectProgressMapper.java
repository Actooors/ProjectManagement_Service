package com.management.dao;

import com.management.model.entity.ProjectProgress;
import com.management.model.entity.ProjectProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProgressMapper {
    int countByExample(ProjectProgressExample example);

    int deleteByExample(ProjectProgressExample example);

    int deleteByPrimaryKey(String projectProgressId);

    int insert(ProjectProgress record);

    int insertSelective(ProjectProgress record);

    List<ProjectProgress> selectByExample(ProjectProgressExample example);

    ProjectProgress selectByPrimaryKey(String projectProgressId);

    int updateByExampleSelective(@Param("record") ProjectProgress record, @Param("example") ProjectProgressExample example);

    int updateByExample(@Param("record") ProjectProgress record, @Param("example") ProjectProgressExample example);

    int updateByPrimaryKeySelective(ProjectProgress record);

    int updateByPrimaryKey(ProjectProgress record);

    //查找到已经立项各个阶段的项目(结题报告审核失败)
    List<ProjectProgress> selectFailProgress(@Param("userId")String userId,@Param("state")int state);
}