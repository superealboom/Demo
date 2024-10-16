package cn.afuo.example.serviceList;

import org.springframework.stereotype.Service;

/**
 * @description: 微信支付
 * @author: tianci
 * @date: 2024/4/7 15:01
 */
@Service
public class WeChatPayService implements PayService {
    @Override
    public PayType getPayType() {
        return PayType.WECHAT_PAY;
    }

    @Override
    public String getPayTypeDesc() {
        return "这是【" + PayType.WECHAT_PAY.getDesc() + "】的支付";
    }
}
