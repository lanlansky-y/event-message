package com.yyz.demo.core.external.impl;

import com.yyz.demo.core.event.EventBuilder;
import com.yyz.demo.core.external.WithdrawService;
import com.yyz.demo.facade.external.domain.request.WithdrawApplyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 16:05
 * @Description:
 */
@Service
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {
    @Resource
    private EventBuilder eventBuilder;

    @Override
    //@BizChainMonitorLog(action = "提现申请") 执行此方法时，记录出入参
    public void applyWithdraw(WithdrawApplyRequest request) {
//        eventBuilder.buildEvent(request.getAccountNo(), "withdrawApplyHandler", );
    }
}
