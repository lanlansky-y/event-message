package com.yyz.demo.facade.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yangyuzhou
 * @Date: 2020/6/26 15:42
 * @Description: 通用结果
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {


    private static final long serialVersionUID = 8185705210077172473L;

    protected boolean success = true;

    protected String errorCode;

    protected String code;

    protected String errorMessage;

    protected T module;

    public static <T> Result<T> ofSuccess(T result){
        Result<T> newResult = new Result<>();
        newResult.setSuccess(true);
        newResult.setModule(result);

        return newResult;
    }
}
