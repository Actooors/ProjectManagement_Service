package com.management.dao;

import com.management.model.entity.ProjectModificationApplication;
import com.management.model.entity.ProjectModificationApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectModificationApplicationMapper {
    int countByExample(ProjectModificationApplicationExample example);

    int deleteByExample(ProjectModificationApplicationExample example);

    int deleteByPrimaryKey(Integer projectModificationApplicationId);

    int insert(ProjectModificationApplication record);

    int insertSelective(ProjectModificationApplication record);

    List<ProjectModificationApplication> selectByExample(ProjectModificationApplicationExample example);

    ProjectModificationApplication selectByPrimaryKey(Integer projectModificationApplicationId);

    int updateByExampleSelective(@Param("record") ProjectModificationApplication record, @Param("example") ProjectModificationApplicationExample example);

    int updateByExample(@Param("record") ProjectModificationApplication record, @Param("example") ProjectModificationApplicationExample example);

    int updateByPrimaryKeySelective(ProjectModificationApplication record);

    int updateByPrimaryKey(ProjectModificationApplication record);
}