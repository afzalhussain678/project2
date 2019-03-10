package com.hussain.project2.services;

import com.hussain.project2.model.AdminDetailsRequest;
import com.hussain.project2.model.AdminDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public AdminDetailsRequest request;

    public void setRequest(AdminDetailsRequest request) {
        this.request = request;
    }

    public AdminDetailsResponse execute(){
        if(!request.getName().equalsIgnoreCase("afzal")){
            return null;
        }
        AdminDetailsResponse adminDetailsResponse= new AdminDetailsResponse("Afzal Hussain",25,5.9,"India");
        return  adminDetailsResponse;
    }
}
