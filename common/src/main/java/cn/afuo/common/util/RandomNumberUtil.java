package cn.afuo.common.util;

import java.math.BigInteger;
import java.util.Random;


public class RandomNumberUtil {

    /**
     * @description: 创建随机数字
     * @author: tianci
     * @date: 2024/3/18 16:09
     */
    public static String getRandom(int count) {
        Random random = new Random();
        BigInteger number = BigInteger.ZERO;

        // 生成11位的随机数，每一位都在1-9之间
        for (int i = 0; i < count; i++) {
            int digit = random.nextInt(9) + 1;
            number = number.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));
        }

        return number.toString();
    }
}
