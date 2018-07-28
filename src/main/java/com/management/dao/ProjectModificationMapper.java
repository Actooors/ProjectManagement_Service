package com.management.dao;

import com.management.model.entity.ProjectModification;
import com.management.model.entity.ProjectModificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectModificationMapper {
    int countByExample(ProjectModificationExample example);

    int deleteByExample(ProjectModificationExample example);

    int deleteByPrimaryKey(Integer projectModificaitonId);

    int insert(ProjectModification record);

    int insertSelective(ProjectModification record);

    List<ProjectModification> selectByExample(ProjectModificationExample example);

    ProjectModification selectByPrimaryKey(Integer projectModificaitonId);

    int updateByExampleSelective(@Param("record") ProjectModification record, @Param("example") ProjectModificationExample example);

    int updateByExample(@Param("record") ProjectModification record, @Param("example") ProjectModificationExample example);

    int updateByPrimaryKeySelective(ProjectModification record);

    int updateByPrimaryKey(ProjectModification record);
}