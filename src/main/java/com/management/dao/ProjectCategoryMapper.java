package com.management.dao;

import com.management.model.entity.ProjectCategory;
import com.management.model.entity.ProjectCategoryExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCategoryMapper {
    int countByExample(ProjectCategoryExample example);

    int deleteByExample(ProjectCategoryExample example);

    int deleteByPrimaryKey(String projectCategoryId);

    int insert(ProjectCategory record);

    int insertSelective(ProjectCategory record);

    List<ProjectCategory> selectByExample(ProjectCategoryExample example);

    ProjectCategory selectByPrimaryKey(String projectCategoryId);

    int updateByExampleSelective(@Param("record") ProjectCategory record, @Param("example") ProjectCategoryExample example);

    int updateByExample(@Param("record") ProjectCategory record, @Param("example") ProjectCategoryExample example);

    int updateByPrimaryKeySelective(ProjectCategory record);

    int updateByPrimaryKey(ProjectCategory record);

    //获取可申报项目ApplicationEndTime>NowTime
    List<ProjectCategory> selectCanProjectCategory(Date time);
}