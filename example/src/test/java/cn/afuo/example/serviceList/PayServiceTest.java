package cn.afuo.example.serviceList;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class PayServiceTest {

    @Autowired
    private List<PayService> payServiceList;

    @Test
    public void testPay() {
        PayType payType = PayType.ALI_PAY;
        PayService payService = payServiceList.stream().filter(pay -> pay.getPayType().equals(payType)).findFirst().orElse(null);
        if (payService != null) {
            String funderDesc = payService.getPayTypeDesc();
            log.info(funderDesc);
        }
    }

}