package cn.afuo.example.captcha;

import cn.afuo.common.constant.RedisConstants;
import cn.afuo.common.util.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class CaptchaService {

    private final RedisUtil redisUtil;

    public CaptchaService(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public CaptchaVO getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 38, 4);
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String captchaId = UUID.randomUUID().toString();
        String captchaCode = specCaptcha.text();
        redisUtil.set(RedisConstants.EXAMPLE_CAPTCHA_PREFIX + captchaId, captchaCode, 30L, TimeUnit.MINUTES);

        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaId(captchaId);
        captchaVO.setCaptchaImage(specCaptcha.toBase64());
        return captchaVO;
    }
}
