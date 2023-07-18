package com.hxy.sentinel.service.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxy.sentinel.service.entity.ResBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 流控统一异常处理类（就不需要@SentinelResource注解）
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        ResBean<String> result = new ResBean<>();
        if (e instanceof FlowException) {
            result.setCode("100");
            result.setSummary("接口限流了");
        } else if (e instanceof DegradeException) {
            result.setCode("101");
            result.setSummary("服务降级了");
        } else if (e instanceof ParamFlowException) {
            result.setCode("102");
            result.setSummary("热点参数限流了");
        } else if (e instanceof SystemBlockException) {
            result.setCode("103");
            result.setSummary("触发系统保护规则了");
        } else if (e instanceof AuthorityException) {
            result.setCode("104");
            result.setSummary("授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), result);
    }

}
