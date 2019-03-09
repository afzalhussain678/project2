package com.hussain.project2.controller;

import com.hussain.project2.model.BaseRequest;
import com.hussain.project2.model.BaseResponse;
import com.hussain.project2.services.BaseService;
import com.hussain.project2.services.NameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/customer",description="Customer Profile",produces ="application/json")
public class BaseController {
    @Autowired
    BaseService baseService;

    @Autowired
    NameService nameService;

    @GetMapping("/home")
    public BaseResponse home() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Hello World");
        baseResponse.setEmail("kuchtob");
        return baseResponse;
    }

    @PostMapping("/addValueToRequest")
    public BaseResponse addValueToRequest(@RequestBody BaseRequest baseRequest) {
        BaseResponse baseResponse = baseService.execute(baseRequest);
        baseResponse.setEmail(baseRequest.getEmail());
        return baseResponse;
    }

    //To do: Please debug the following endpoint
    @GetMapping("/name/{age}")
    public String returnName(@RequestParam String country,
                             @PathVariable int age) {
        String name = "";
        name = nameService.getName();
        return name + " belongs to country: " + country + " and his age is " + age;
    }

    @GetMapping("/number")
    public int returNumber() {
       return nameService.number();




    }
}