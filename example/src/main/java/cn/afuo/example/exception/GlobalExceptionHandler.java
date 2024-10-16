package cn.afuo.example.exception;


import cn.afuo.common.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyExampleException.class)
    public ResponseEntity<Result<?>> handleMyExampleException(MyExampleException e) {
        return new ResponseEntity<>(Result.fail().code(5000).message(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
