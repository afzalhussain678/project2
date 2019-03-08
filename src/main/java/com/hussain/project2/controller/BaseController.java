package com.hussain.project2.controller;

import com.hussain.project2.model.BaseRequest;
import com.hussain.project2.model.BaseResponse;
import com.hussain.project2.services.BaseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/customer",description="Customer Profile",produces ="application/json")
public class BaseController {
    @Autowired
    BaseService baseService;

    @GetMapping("/home")
    public BaseResponse home(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Hello World");
        return baseResponse;
    }
    @PostMapping("/addValueToRequest")
    public BaseResponse addValueToRequest(@RequestBody  BaseRequest baseRequest){
        BaseResponse baseResponse=baseService.execute(baseRequest);
        return baseResponse;
    }


}
