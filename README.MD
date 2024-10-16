## 版本

- springboot 2.7.18
- jdk 8
- mysql 8.0.33
- mybatisPlus, thymeleaf, bootstrap5, redis, redisson

> github链接：https://github.com/superealboom/demo
>
> gitee链接：https://gitee.com/superealboom/demo

## 主要内容

### comon

> 公共模块

1. FunctionLog 注解：打印方法入参出参日志
2. NoRepeatSubmit注解：防重提交，自定义时间
3. RedissonConfig：redisson分布式锁
4. RedisUitl: 集成RedisTemplate封装redis方法
5. 统一返回体 Result 对象
6. JsonUtil：使用Jackson对json处理

### example

> 测试例子模块

1. GameAspect：AOP各方法执行顺序测试
2. easy-captcha：验证码获取校验测试 `http://localhost:8020/example/captcha/index`
3. mybatis Plus批量新增
4. GlobalExceptionHandler：自定义异常，异常全局获取
5. Jackson, lambda, lombok, predicate,serializable 使用测试
6. 多线程：ExecutorService, CountDownLatch, Future, CompletableFuture, runAsync, supplyAsync使用
7. serviceList测试
8. 读取txt文件测试

![image-20241014162126242](./assets/image-20241014162126242.png)

### largeFile

> 大文件上传模块

1. `http://localhost:8010/largefile/file/index` 文件上传地址
2. `largeFile/src/main/resources/largeFile` 文件夹存放文件
3. `largeFile/uploadChunks` 文件夹存放分割的块
4. 分割块大小前端默认`chunkSize 1M` ，异步上传，后台组装通过分布式锁合并文件
5. 支持分割上传，断点续传，续传根据文件名判断

![image-20241014162208184](./assets/image-20241014162208184.png)

有期可优化拓展：

1. 根据文件大小动态变化`chunkSize` 
2. 文件上传目录可更改 oss
3. 根据文件名判断文件可更改置根据文件的md5值等判断
4. 增加数据库表记录统计数据，文件位置，块详情
5. 页面可以增加块上传进度
6. 也可将文件分割放到后台使用多线程来做

