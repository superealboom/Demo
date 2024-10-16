package cn.afuo.largefile.config;

import cn.afuo.common.aspect.FunctionLogAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class CommonConfig {

    @Import(FunctionLogAspect.class)
    private static class importFunctionLogAspect {}
}