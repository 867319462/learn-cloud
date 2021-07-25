package com.cloud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 支付实体类
 *
 * @author wangxl
 * @date 2021/7/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serial;

}
