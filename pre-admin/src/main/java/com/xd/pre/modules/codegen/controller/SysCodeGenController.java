package com.xd.pre.modules.codegen.controller;

import com.xd.pre.common.utils.R;
import com.xd.pre.modules.codegen.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SysCodeGenController
 * @Description 代码生成
 * @Author Created by Lihaodong (alias:小东啊) lihaodongmail@163.com
 * @Date 2019-08-02 14:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/codegen")
public class SysCodeGenController {

    @Autowired
    private SysCodeService sysCodeService;

    /**
     * 获取数据库的所有表
     *
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableList")
    public R getTableList(@RequestParam String tableSchema) {
        return R.ok(sysCodeService.findTableList(tableSchema));
    }

    /**
     * 获取表中的所有字段以及列属性
     * @param tableName
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableColumnList")
    public R getTableColumnList(@RequestParam String tableName,@RequestParam String tableSchema) {
        return R.ok(sysCodeService.findColumnList(tableName, tableSchema));
    }


}