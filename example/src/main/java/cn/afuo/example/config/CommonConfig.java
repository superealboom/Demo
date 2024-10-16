package cn.afuo.example.config;

import cn.afuo.common.aspect.FunctionLogAspect;
import cn.afuo.common.config.RedisTemplateConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class CommonConfig {

    @Import(FunctionLogAspect.class)
    private static class importFunctionLogAspect {}

    @Import(RedisTemplateConfig.class)
    private static class ImportRedisTemplateConfig {}
}