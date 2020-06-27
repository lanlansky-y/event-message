package com.yyz.demo.core.event;

import com.google.common.collect.Maps;
import com.yyz.demo.dal.mapper.EventMessageMapper;
import com.yyz.demo.dal.model.EventMessageDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 17:51
 * @Description: 事件生成器
 */
@Slf4j
@Component("eventBuilder")
public class EventBuilder {

    @Resource
    private EventMessageMapper eventMessageMapper;

    private static final String SYS = "SYS";

    /**
     * 事件提交iss执行
     * @param eventId 事件id
     */
    private void submitIss(long eventId){
        submitIss(eventId, 0);
    }

    /**
     * 事件延时提交iss执行
     * @param eventId
     * @param waitSecond
     */
    private void submitIss(long eventId, int waitSecond){
        EventMessageDO messageInDb = eventMessageMapper.getById(eventId);
        if (messageInDb == null){
            log.error("事件不存在， eventId:{}", eventId);
            throw new RuntimeException("事件不存在，eventId:" + eventId);
        }
        if (!needRedo(messageInDb.getStatus())){
            log.error("当前事件非可执行状态，不做事件提交，eventId:{}, eventMessageDO:{}", eventId, messageInDb);
            throw new RuntimeException("当前事件非可执行状态, 提交iss执行失败：" + eventId);
        }
        Map<String, String> issParam = Maps.newHashMap();
        issParam.put("eventId", String.valueOf(eventId));
        // todo 执行任务
        //PublishResult publishResult = issService.submitJob(eventJob, issParam, waitSecond, 99, 10, 3);
        EventMessageDO updateDO = new EventMessageDO();
        updateDO.setId(eventId);
        updateDO.setContext(messageInDb.getContext());
        if (updateDO.getContext() == null){
            updateDO.setContext(Maps.newHashMap());
        }
//        updateDO.getContext().put("rootId", )

        eventMessageMapper.update(updateDO);
    }

    /**
     * 生成并写入异步事件
     * @param bizId   业务id
     * @param bizType 业务类型
     * @param params  请求参数
     */
    public void buildEvent(String bizId, String bizType, String params){
        EventMessageDO eventMessageDO = insertEvent(bizId, bizType, params, "INIT");
        submitIss(eventMessageDO.getId());
    }

    /**
     * 事件是否需要调度执行
     * @param eventStatus
     * @return
     */
    private boolean needRedo(String eventStatus){
        return "FAIL".equals(eventStatus) || "INIT".equals(eventStatus);
    }

    private EventMessageDO insertEvent(String bizId, String bizType, String params, String status){
        EventMessageDO eventMessageDO = new EventMessageDO();
        eventMessageDO.setBizId(bizId);
        eventMessageDO.setBizType(bizType);
        eventMessageDO.setEnv("PROD");
        Date now = new Date();
        eventMessageDO.setGmtCreate(now);
        eventMessageDO.setGmtModified(now);
        eventMessageDO.setStatus(status);
        eventMessageDO.setGmtCreator(SYS);
        eventMessageDO.setGmtModifier(SYS);
        eventMessageDO.setRetryCount(0);
        eventMessageDO.setParams(params);

        eventMessageMapper.insert(eventMessageDO);
        System.out.println(eventMessageDO);
        return eventMessageDO;
    }
}
