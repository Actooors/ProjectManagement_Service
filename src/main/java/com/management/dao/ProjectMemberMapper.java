package com.management.dao;

import com.management.model.entity.ProjectMember;
import com.management.model.entity.ProjectMemberExample;
import com.management.model.entity.ProjectMemberKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMemberMapper {
    int countByExample(ProjectMemberExample example);

    int deleteByExample(ProjectMemberExample example);

    int deleteByPrimaryKey(ProjectMemberKey key);

    int insert(ProjectMember record);

    int insertSelective(ProjectMember record);

    List<ProjectMember> selectByExample(ProjectMemberExample example);

    ProjectMember selectByPrimaryKey(ProjectMemberKey key);

    int updateByExampleSelective(@Param("record") ProjectMember record, @Param("example") ProjectMemberExample example);

    int updateByExample(@Param("record") ProjectMember record, @Param("example") ProjectMemberExample example);

    int updateByPrimaryKeySelective(ProjectMember record);

    int updateByPrimaryKey(ProjectMember record);

    //根据项目申请id删除
    int deleteByApplication(String applicationId);

    List<ProjectMember> selectByApplicationId(String applicationId);
}