package net.lab1024.sa.admin.module.dbinfo.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 数据库表信息 实体类
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@Data
@TableName("data_db_count")
public class BCounEntity {

    /**
     * 表ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 数据库IP端口
     */
    private String dbInfo;

    /**
     * 数据库Schema
     */
    private String dbSchema;

    /**
     * 数据库用户
     */
    private String dbUser;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表注释
     */
    private String tableDesc;

    /**
     * 数据条数
     */
    private Integer allCount;

    /**
     * 删除数据
     */
    private Integer deleteCount;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
