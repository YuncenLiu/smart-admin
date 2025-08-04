package net.lab1024.sa.admin.module.dbinfo.domain.form;

import net.lab1024.sa.base.common.domain.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据库表信息 分页查询表单
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BCounQueryForm extends PageParam {

    @Schema(description = "tableName")
    private String tableName;

    @Schema(description = "tableDesc")
    private String tableDesc;

    @Schema(description = "数据库Schema")
    private String dbSchema;

}
