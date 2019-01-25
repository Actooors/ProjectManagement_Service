package com.management.dao;

import com.management.model.entity.ProjectApplication;
import com.management.model.entity.ProjectApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectApplicationMapper {
    int countByExample(ProjectApplicationExample example);

    int deleteByExample(ProjectApplicationExample example);

    int deleteByPrimaryKey(Integer projectApplicationId);

    int insert(ProjectApplication record);

    int insertSelective(ProjectApplication record);

    List<ProjectApplication> selectByExample(ProjectApplicationExample example);

    ProjectApplication selectByPrimaryKey(Integer projectApplicationId);

    List<ProjectApplication> queryAllProgressAndFailProject(String userId);

    int updateByExampleSelective(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByExample(@Param("record") ProjectApplication record, @Param("example") ProjectApplicationExample example);

    int updateByPrimaryKeySelective(ProjectApplication record);

    int updateByPrimaryKey(ProjectApplication record);
}