package cn.afuo.example.aspect;


import cn.afuo.common.annotation.FunctionLog;
import cn.afuo.common.annotation.NoRepeatSubmit;
import cn.afuo.common.domain.Result;
import cn.afuo.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 测试 AOP 方法顺序
 */
@Slf4j
@RequestMapping("AOP")
@RestController
public class AspectController {

    /**
     * 环绕通知执行前
     * 玩游戏前
     * url=
     * method=
     * ip=
     * class_method=
     * args=[]
     * 开始玩儿【】游戏
     * 玩游戏后且没有异常 or 玩游戏后且有异常
     * 玩游戏后
     * 环绕通知执行后(抛异常不走这个方法)
     */
    @GetMapping("/doGame")
    public void doGame(String gameName) {
        log.info("开始玩儿【{}】游戏", gameName);
    }


    /**
     * 测试防重提交
     */
    @GetMapping("/listGame")
    @NoRepeatSubmit(timeout = 10000)
    public Result<?> listGame() {
        List<String> gameList = Arrays.asList("CF","LOL");
        log.info("游戏列表 {}", JsonUtil.toJson(gameList));
        return Result.success(gameList);
    }

    /**
     * 测试打印日志GET
     */
    @GetMapping("/gameLog")
    @FunctionLog(desc = "测试打印日志功能GET")
    public Result<?> getGameLog(String playerName, String gameName) {
        log.info("{}要玩儿{}游戏", playerName, gameName);
        return Result.success("结束");
    }

    /**
     * 测试打印日志POST
     */
    @PostMapping("/gameLog")
    @FunctionLog(desc = "测试打印日志功能POST")
    public Result<?> postGameLog(@RequestBody GameVO gameVO) {
        log.info("{}要玩儿{}游戏", gameVO.getPlayerName(), gameVO.getGameName());
        return Result.success("结束");
    }
}
