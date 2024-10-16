package cn.afuo.example.utils;


import cn.afuo.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void del() {
        redisUtil.del("key1");
    }

    @Test
    public void expire() {
        redisUtil.expire("key1", 10);
    }

}