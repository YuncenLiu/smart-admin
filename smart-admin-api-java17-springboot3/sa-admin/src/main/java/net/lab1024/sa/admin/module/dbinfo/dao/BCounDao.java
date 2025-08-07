package net.lab1024.sa.admin.module.dbinfo.dao;

import java.util.List;
import net.lab1024.sa.admin.module.dbinfo.domain.entity.BCounEntity;
import net.lab1024.sa.admin.module.dbinfo.domain.form.BCounQueryForm;
import net.lab1024.sa.admin.module.dbinfo.domain.vo.BCounVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

/**
 * 数据库表信息 Dao
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@Mapper
public interface BCounDao extends BaseMapper<BCounEntity> {

    /**
     * 分页 查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<BCounVO> queryPage(Page page, @Param("queryForm") BCounQueryForm queryForm);

    /**
     * 调用存储过程
     *
     * @param host 数据库IP端口
     * @param schema 数据库实例名称
     * @param username 用户
     */
    @Select("{CALL scan_database_tables(#{host}, #{schema}, #{username})}")
    @Options(statementType = StatementType.CALLABLE)
    void callScanDatabaseTables(
            @Param("host") String host,
            @Param("schema") String schema,
            @Param("username") String username
    );
}
