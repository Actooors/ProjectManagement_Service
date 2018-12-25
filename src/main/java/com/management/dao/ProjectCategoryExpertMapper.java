package com.management.dao;

import com.management.model.entity.ProjectCategoryExpert;
import com.management.model.entity.ProjectCategoryExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCategoryExpertMapper {
    int countByExample(ProjectCategoryExpertExample example);

    int deleteByExample(ProjectCategoryExpertExample example);

    int deleteByPrimaryKey(Integer projectExpertId);

    int insert(ProjectCategoryExpert record);

    int insertSelective(ProjectCategoryExpert record);

    List<ProjectCategoryExpert> selectByExample(ProjectCategoryExpertExample example);

    ProjectCategoryExpert selectByPrimaryKey(Integer projectExpertId);

    int updateByExampleSelective(@Param("record") ProjectCategoryExpert record, @Param("example") ProjectCategoryExpertExample example);

    int updateByExample(@Param("record") ProjectCategoryExpert record, @Param("example") ProjectCategoryExpertExample example);

    int updateByPrimaryKeySelective(ProjectCategoryExpert record);

    int updateByPrimaryKey(ProjectCategoryExpert record);
}