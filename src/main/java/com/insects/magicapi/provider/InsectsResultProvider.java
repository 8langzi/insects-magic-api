package com.insects.magicapi.provider;

import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.context.RequestEntity;
import org.ssssssss.magicapi.core.interceptor.ResultProvider;
import org.ssssssss.magicapi.core.model.JsonBean;

/***
 *  @Date: 2022/5/11 2:39
 *  @Description:
 */
@Component
public class InsectsResultProvider implements ResultProvider {

     // global exception handing methods
    @Override
    public Object buildException(RequestEntity requestEntity, Throwable throwable) {
        return buildResult(requestEntity, 500, "inteval server error");
    }

    // global result handing methods
    @Override
    public Object buildResult(RequestEntity requestEntity, int code, String message, Object data) {
        long timeStamp = System.currentTimeMillis();
        return new JsonBean<>(code,message,data,(int)(timeStamp - requestEntity.getRequestTime()));
    }
}
