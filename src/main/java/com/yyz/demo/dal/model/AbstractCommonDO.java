package com.yyz.demo.dal.model;

import com.yyz.demo.facade.common.base.ToStringHelper;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 17:53
 * @Description:
 */
@Data
public class AbstractCommonDO extends ToStringHelper {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 创建者
     */
    private String gmtCreator;

    /**
     * 修改者
     */
    private String gmtModifier;
}
