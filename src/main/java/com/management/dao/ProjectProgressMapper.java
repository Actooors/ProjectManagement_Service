package com.management.dao;

import com.management.model.entity.ProjectProgress;
import com.management.model.entity.ProjectProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProgressMapper {
    int countByExample(ProjectProgressExample example);

    int deleteByExample(ProjectProgressExample example);

    int deleteByPrimaryKey(Integer projectProgressId);

    int insert(ProjectProgress record);

    int insertSelective(ProjectProgress record);

    List<ProjectProgress> selectByExample(ProjectProgressExample example);

    ProjectProgress selectByPrimaryKey(Integer projectProgressId);

    int updateByExampleSelective(@Param("record") ProjectProgress record, @Param("example") ProjectProgressExample example);

    int updateByExample(@Param("record") ProjectProgress record, @Param("example") ProjectProgressExample example);

    int updateByPrimaryKeySelective(ProjectProgress record);

    int updateByPrimaryKey(ProjectProgress record);
}