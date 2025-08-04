package net.lab1024.sa.admin.module.dbinfo.dao;

import java.util.List;
import net.lab1024.sa.admin.module.dbinfo.domain.entity.BCounEntity;
import net.lab1024.sa.admin.module.dbinfo.domain.form.BCounQueryForm;
import net.lab1024.sa.admin.module.dbinfo.domain.vo.BCounVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

}
