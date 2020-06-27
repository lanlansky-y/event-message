package com.yyz.demo.facade.external.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 15:50
 * @Description:
 */
@Data
public class WithdrawApplyRequest implements Serializable {

    private static final long serialVersionUID = 8743021461377015179L;

    /**
     * 申请编号，幂等键
     */
    private String applyNo;

    /**
     * 贷款客户id
     */
    private String userId;

    /**
     * 贷款客户站点
     */
    private String site;

    /**
     * 提现金额，单位：分
     */
    private Long amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 通道类型
     */
    private String channel;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 账户类型
     */
    private String accountType;

}
