package com.yyz.demo.dal.mapper;

import com.yyz.demo.dal.model.EventMessageDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 18:14
 * @Description:
 */
@Repository
@Mapper
public interface EventMessageMapper {

    /**
     * 新增一条调度事件信息
     * @param eventMessageDO
     * @return
     */
    int insert(EventMessageDO eventMessageDO);

    /**
     * 通过主键查询事件
     * @param id
     * @return
     */
    EventMessageDO getById(Long id);

    /**
     * 修改
     * @param eventMessageDO
     */
    void update(EventMessageDO eventMessageDO);
}
