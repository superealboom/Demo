package cn.afuo.example.serviceList;

import org.springframework.stereotype.Service;

/**
 * @description: 支付宝支付
 * @author: tianci
 * @date: 2024/4/7 15:00
 */
@Service
public class ALiPayService implements PayService {


    @Override
    public PayType getPayType() {
        return PayType.ALI_PAY;
    }

    @Override
    public String getPayTypeDesc() {
        return "这是【" + PayType.ALI_PAY.getDesc() + "】的支付";
    }
}
