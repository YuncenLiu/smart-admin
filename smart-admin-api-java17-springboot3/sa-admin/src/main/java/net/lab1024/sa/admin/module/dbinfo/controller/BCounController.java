package net.lab1024.sa.admin.module.dbinfo.controller;

import net.lab1024.sa.admin.module.dbinfo.domain.form.BCounQueryForm;
import net.lab1024.sa.admin.module.dbinfo.domain.vo.BCounVO;
import net.lab1024.sa.admin.module.dbinfo.service.BCounService;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.domain.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

/**
 * 数据库表信息 Controller
 *
 * @Author yun
 * @Date 2025-08-04 16:02:55
 * @Copyright liuyuncen.com
 */

@RestController
@Tag(name = "数据库表信息")
public class BCounController {

    @Resource
    private BCounService bCounService;

    @Operation(summary = "分页查询 @author yun")
    @PostMapping("/bCoun/queryPage")
    @SaCheckPermission("bCoun:query")
    public ResponseDTO<PageResult<BCounVO>> queryPage(@RequestBody @Valid BCounQueryForm queryForm) {
        return ResponseDTO.ok(bCounService.queryPage(queryForm));
    }

    @Operation(summary = "获取数据 @author yun")
    @PostMapping("/bCoun/loadData")
    @SaCheckPermission("bCoun:loadData")
    public ResponseDTO<Boolean> queryPage() {
        return ResponseDTO.ok(bCounService.loadData());
    }
}
