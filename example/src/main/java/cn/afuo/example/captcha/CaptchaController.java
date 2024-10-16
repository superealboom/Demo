package cn.afuo.example.captcha;

import cn.afuo.common.constant.RedisConstants;
import cn.afuo.common.domain.Result;
import cn.afuo.common.util.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 验证码
 */
@Slf4j
@RestController
@RequestMapping("captcha")
public class CaptchaController {

    private final CaptchaService captchaService;

    private final RedisUtil redisUtil;

    public CaptchaController(RedisUtil redisUtil, CaptchaService captchaService) {
        this.redisUtil = redisUtil;
        this.captchaService = captchaService;
    }

    /**
     * 验证码页面
     */
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modules/captcha/index");
        CaptchaVO captchaVO = captchaService.getCaptcha();
        modelAndView.addObject("captchaVO", captchaVO);
        return modelAndView;
    }

    /**
     * 获取验证码
     */
    @GetMapping("/getCaptcha")
    public Result<?> getCaptcha() {
        CaptchaVO captchaVO = captchaService.getCaptcha();
        return Result.success(captchaVO);
    }

    /**
     * 校验验证码
     */
    @PostMapping("/checkCaptcha")
    public Result<?> checkCaptcha(CaptchaVO captchaVO) {
        String captchaCode = (String) redisUtil.get(RedisConstants.EXAMPLE_CAPTCHA_PREFIX + captchaVO.getCaptchaId());
        if (captchaVO.getCaptchaCode().equals(captchaCode)) {
            return Result.success().message("验证成功");
        }
        return Result.fail().message("验证失败");
    }
}
