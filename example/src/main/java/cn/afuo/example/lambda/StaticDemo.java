package cn.afuo.example.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态类调用
 */
@Slf4j
public class StaticDemo {

    public static void main(String[] args) {
        StaticDemoInterface staticDemoInterface = StaticDemoSubtraction::subtract;
        int test = staticDemoInterface.test(1, 2);
        log.info("两个整数相减的绝对值：{}", test);
    }
}
