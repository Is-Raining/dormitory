package com.example.dormitory.interfaces;

/**
 * 结果枚举接口
 * @author Xiaozeng
 * @date 2022-10-12
 */
public interface ResultInterface {

    /**
     * 获取状态编码
     * @return 编码
     */
    Integer getCode();

    /**
     * 获取提示信息
     * @return 提示信息
     */
    String getMessage();

}
