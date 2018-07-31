package com.management.model.ov.resultsetting;
import lombok.Data;
/**
 * @program: management
 * @description: 指定项目类别的项目大类的列表信息
 * @author: ggmr
 * @create: 2018-07-31 18:40
 */
@Data
public class ProjectCategoryListInfo {
    private String projectCategoryName;
    private String applicantType;
    private String applicationDeadline;
}
