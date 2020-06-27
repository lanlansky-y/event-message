package com.yyz.demo.facade.external.service;

import com.yyz.demo.facade.common.base.Result;
import com.yyz.demo.facade.external.domain.request.WithdrawApplyRequest;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 15:41
 * @Description: 提现api
 */
public interface WithdrawFacade {

    /**
     * 提现申请
     * @param request
     * @return
     */
    Result<Void> applyWithdraw(WithdrawApplyRequest request);
}
