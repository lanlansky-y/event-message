package com.yyz.demo.core.external;

import com.yyz.demo.facade.external.domain.request.WithdrawApplyRequest;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 16:03
 * @Description: 提现服务
 */
public interface WithdrawService {

    /**
     * 提现申请
     * @param request
     */
    void applyWithdraw(WithdrawApplyRequest request);
}
