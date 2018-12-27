package com.management.dao;

import com.management.model.entity.ReviewExpert;
import com.management.model.entity.ReviewExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewExpertMapper {
    int countByExample(ReviewExpertExample example);

    int deleteByExample(ReviewExpertExample example);

    int deleteByPrimaryKey(Integer reviewExpertId);

    int insert(ReviewExpert record);

    int insertSelective(ReviewExpert record);

    List<ReviewExpert> selectByExample(ReviewExpertExample example);

    ReviewExpert selectByPrimaryKey(Integer reviewExpertId);

    ReviewExpert selectByProjectApplicationId(Integer projectApplicationId);

    int updateByExampleSelective(@Param("record") ReviewExpert record, @Param("example") ReviewExpertExample example);

    int updateByExample(@Param("record") ReviewExpert record, @Param("example") ReviewExpertExample example);

    int updateByPrimaryKeySelective(ReviewExpert record);

    int updateByPrimaryKey(ReviewExpert record);
}