package cn.afuo.example.exception;


import cn.afuo.common.domain.Result;
import cn.afuo.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("exception")
@RestController
public class ExceptionController {

    /**
     * @description: 自定义异常
     * @author: tianci
     * @date: 2024/7/29 11:47
     */
    @GetMapping("myExampleException")
    public Result<?> testException(@RequestParam("exceptionCode") Integer exceptionCode) {
        if (ResultEnum.FAIL.getCode() == exceptionCode) {
            throw new MyExampleException("测试自定义异常");
        }
        return Result.success("结束");
    }

}
