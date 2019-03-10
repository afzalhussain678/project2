package com.hussain.project2.controller;

import com.hussain.project2.model.AdminDetailsRequest;
import com.hussain.project2.model.AdminDetailsResponse;
import com.hussain.project2.model.BaseRequest;
import com.hussain.project2.model.BaseResponse;
import com.hussain.project2.services.AdminService;
import com.hussain.project2.services.BaseService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/customer",description="Customer Profile",produces ="application/json")
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    BaseService baseService;
    @Autowired
    AdminService adminService;


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

    @PostMapping("/adminDetails")
    public AdminDetailsResponse admindetails(@RequestBody AdminDetailsRequest adminDetailsRequest){
        adminService.setRequest(adminDetailsRequest);
        logger.info("Request Received: {}", adminDetailsRequest);
        return adminService.execute();
    }


}