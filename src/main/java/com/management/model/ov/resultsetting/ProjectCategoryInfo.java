package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 某个项目大类的具体信息
 * @author: ggmr
 * @create: 2018-07-31 19:55
 */
@Data
public class ProjectCategoryInfo {
      private String projectCategoryName;
      private String applicantType;
      private String projectCategoryDescription;
      private String projectCategoryDescriptionAddress;
      private Integer projectType;
      private String principalId;
      private String principalName;
      private String maxMoney;
      private String reviewLeaderName;
      private String projectApplicationDownloadAddress;
      private String applicationStartTime;
      private String applicationDeadLine;
      private String projectStartTime;
      private String projectDeadline;
}
