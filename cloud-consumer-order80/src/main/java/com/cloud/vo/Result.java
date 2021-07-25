package com.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应
 *
 * @author wangxl
 * @date 2021/7/25 15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
