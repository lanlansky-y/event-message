package com.yyz.demo.dal.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 17:53
 * @Description: 调度事件信息
 */
@Data
public class EventMessageDO extends AbstractCommonDO implements Serializable {

    private static final long serialVersionUID = -7985309139724678398L;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 状态
     */
    private String status;

    /**
     * 任务参数，JSON格式
     */
    private String params;

    /**
     * 重试次数
     */
    private int retryCount;

    /**
     * 环境编号
     */
    private String env;

    /**
     * 执行上下文
     */
    private Map<String, String> context = new HashMap<>();

}
