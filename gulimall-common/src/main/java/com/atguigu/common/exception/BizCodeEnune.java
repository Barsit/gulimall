package com.atguigu.common.exception;

/**
 * @description:
 * @projectName:gulimall
 * @see:com.atguigu.common.exception
 * @author:db
 * @createTime:2024/10/5 11:39
 * @version:1.0
 */
public enum BizCodeEnune {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    ValidException(10001,"参数格式校验失败"),
    SKU_LOCK_EXCEPTION(21000,"商品库存不足");

    private int code;
    private String msg;

    BizCodeEnune(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
