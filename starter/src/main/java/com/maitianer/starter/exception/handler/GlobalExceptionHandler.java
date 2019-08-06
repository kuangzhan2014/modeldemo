package com.maitianer.starter.exception.handler;


import com.maitianer.starter.exception.model.TradeRuntimeException;
import com.maitianer.starter.modules.common.model.ResultData;
import com.maitianer.common.CommonBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author yuzhe
 * @Date 2018/11/6 18:22
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultData javaExceptionHandler(Exception ex) {
        logger.error("捕获到Exception异常", ex);
        logger.error("捕获到Exception异常", ex.toString());
        return new ResultData(1, ex.getMessage());
    }

    /**
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CommonBaseException.class)//MessageCenterException是自定义的一个异常
    public ResultData messageCenterExceptionHandler(CommonBaseException ex) {
        logger.error("捕获到CommonException异常", ex);
        return new ResultData(ex.getCode(), ex.getMessage());
    }

    /**
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = TradeRuntimeException.class)//MessageCenterException是自定义的一个异常
    public ResultData messageCenterExceptionHandler(TradeRuntimeException ex) {
        logger.error("捕获到CommonException异常", ex);
        return new ResultData(ex.getCode(), "审核失败, " + ex.getCause().getMessage() + "!");
    }
}
