package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 某个项目员负责的项目大类的信息
 * @author: ggmr
 * @create: 2018-08-15 15:06
 */
@Data
public class SomeoneAllProjectCategoryInfo {
    private String projectCategoryName;
    private Integer finishPeople;
    private Integer type;
    private String projectDeadline;
}
