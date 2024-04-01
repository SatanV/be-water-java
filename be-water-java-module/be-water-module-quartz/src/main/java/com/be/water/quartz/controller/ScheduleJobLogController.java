package com.be.water.quartz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.quartz.convert.ScheduleJobLogConvert;
import com.be.water.quartz.entity.ScheduleJobLogEntity;
import com.be.water.quartz.query.ScheduleJobLogQuery;
import com.be.water.quartz.service.ScheduleJobLogService;
import com.be.water.quartz.vo.ScheduleJobLogVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@RestController
@RequestMapping("schedule/log")
@Tag(name = "定时任务日志")
@AllArgsConstructor
public class ScheduleJobLogController {
    private final ScheduleJobLogService scheduleJobLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('schedule:log')")
    public Result<PageResult<ScheduleJobLogVO>> page(@ParameterObject @Valid ScheduleJobLogQuery query) {
        PageResult<ScheduleJobLogVO> page = scheduleJobLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('schedule:log')")
    public Result<ScheduleJobLogVO> get(@PathVariable("id") Long id) {
        ScheduleJobLogEntity entity = scheduleJobLogService.getById(id);

        return Result.ok(ScheduleJobLogConvert.INSTANCE.convert(entity));
    }

}