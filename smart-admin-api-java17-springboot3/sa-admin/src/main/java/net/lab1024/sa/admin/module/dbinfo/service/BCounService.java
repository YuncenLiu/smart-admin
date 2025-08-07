package net.lab1024.sa.admin.module.dbinfo.service;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.dbinfo.dao.BCounDao;
import net.lab1024.sa.admin.module.dbinfo.domain.form.BCounQueryForm;
import net.lab1024.sa.admin.module.dbinfo.domain.vo.BCounVO;
import net.lab1024.sa.base.common.util.SmartPageUtil;
import net.lab1024.sa.base.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import javax.sql.DataSource;

/**
 * 数据库表信息 Service
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@Service
@Slf4j
public class BCounService {

    @Resource
    private BCounDao bCounDao;
    @Resource(name = "databaseInfo")
    private Map<String, String> databaseInfo;

    /**
     * 分页查询
     */
    public PageResult<BCounVO> queryPage(BCounQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<BCounVO> list = bCounDao.queryPage(page, queryForm);
        return SmartPageUtil.convert2PageResult(page, list);
    }


    /**
     * @description: 获取数据
     * @author: Xiang想
     * @date: 2025/8/4 17:47
     * @param: []
     * @return: java.lang.Boolean
     **/
    public Boolean loadData() {
        String dbInfo = databaseInfo.get("ip") + ":" + databaseInfo.get("port");
        bCounDao.callScanDatabaseTables(dbInfo, "xiang", databaseInfo.get("username"));
        return Boolean.TRUE;
    }
}
