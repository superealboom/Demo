package cn.afuo.example.captcha;

import lombok.Data;

@Data
public class CaptchaVO {

    private String captchaId;

    private String captchaCode;

    private String captchaImage;
}
