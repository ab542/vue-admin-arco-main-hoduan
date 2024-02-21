package com.liying.back.graducation.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liying
 * @since 2024-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID，角色表主键
     */
    private Integer roleId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;


}
