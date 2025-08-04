package net.lab1024.sa.admin.module.dbinfo.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 数据库表信息 列表VO
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@Data
public class BCounVO {


    @Schema(description = "数据库IP端口")
    private String dbInfo;

    @Schema(description = "数据库Schema")
    private String dbSchema;

    @Schema(description = "数据库用户")
    private String dbUser;

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "表注释")
    private String tableDesc;

    @Schema(description = "数据条数")
    private Integer allCount;

    @Schema(description = "删除数据")
    private Integer deleteCount;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
