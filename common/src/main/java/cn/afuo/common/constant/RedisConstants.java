package cn.afuo.common.constant;


public class RedisConstants {

    /**
     * 公共模块 分布式锁前缀
     */
    public static final String COMMON_LOCK_PREFIX = "common:lock:";

    /**
     * 大文件模块 分布式锁前缀
     */
    public static final String LARGEFILE_LOCK_PREFIX = "largefile:lock:";


    /**
     * 例子模块 验证码前缀
     */
    public static final String EXAMPLE_CAPTCHA_PREFIX = "example:captcha:";

    /**
     * 合并大文件锁时间
     */
    public static final long MERGE_LARGEFILE_LOCK_TIME = 10000;




}
