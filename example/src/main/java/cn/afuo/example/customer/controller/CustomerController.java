package cn.afuo.example.customer.controller;


import cn.afuo.common.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: Thymeleaf 使用
 * @author: tianci
 * @date: 2024/8/24 21:17
 */
@Slf4j
@Controller
@RequestMapping("customer")
public class CustomerController {


    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置跳转的视图
        modelAndView.setViewName("modules/customer/index");
        modelAndView.addObject("title", "Thymeleaf 使用");
        modelAndView.addObject("desc", "Spring Boot 整合 Thymeleaf");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/sendBack")
    public Result<?> sendBack(@RequestParam("backName") String backName) {
        log.info("backName:{}", backName);
        return Result.success();
    }

}
