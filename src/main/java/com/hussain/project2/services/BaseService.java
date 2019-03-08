package com.hussain.project2.services;

import com.hussain.project2.model.BaseRequest;
import com.hussain.project2.model.BaseResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Value("${my.email}")
    private String email;
    @HystrixCommand(fallbackMethod = "defaultEmail")
    public BaseResponse execute(BaseRequest baseRequest){
        baseRequest.setEmail(email);
        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setMessage("Succesfully added value from property file");
        baseResponse.setEmail(email);
        return baseResponse;
    }
    private BaseResponse defaultEmail(BaseRequest baseRequest){
        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setMessage("Hstrix fall back invoked added value from property file");
        baseResponse.setEmail("MyEmail");
        return baseResponse;

    }
}
