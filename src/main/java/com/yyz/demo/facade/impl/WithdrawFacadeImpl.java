package com.yyz.demo.facade.impl;

import com.alibaba.fastjson.JSON;
import com.yyz.demo.core.external.WithdrawService;
import com.yyz.demo.facade.common.base.Result;
import com.yyz.demo.facade.external.domain.request.WithdrawApplyRequest;
import com.yyz.demo.facade.external.service.WithdrawFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 15:59
 * @Description:
 */
@Slf4j
@Controller
public class WithdrawFacadeImpl implements WithdrawFacade {

    @Autowired
    private WithdrawService withdrawService;

    @Override
    public Result<Void> applyWithdraw(WithdrawApplyRequest request) {
        log.info("WithdrawFacade applyWithdraw param{}", JSON.toJSONString(request));
        withdrawService.applyWithdraw(request);
        return Result.ofSuccess(null);
    }
}
