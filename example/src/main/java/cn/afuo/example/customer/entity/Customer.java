package cn.afuo.example.customer.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 手机号
     */
    private String phone;
}
