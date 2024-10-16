package cn.afuo.example.serviceList;

import lombok.Getter;


@Getter
public enum PayType {
    ALI_PAY(0, "支付宝"),
    WECHAT_PAY(1, "微信"),

    ;


    PayType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

}
