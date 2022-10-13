package com.example.dormitory.vo;

import lombok.Data;

//VO:视图层，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来,用于传给前端的对象。
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;

}
