package com.somesh.bdd.fw.pojo.api;

import com.somesh.bdd.fw.constant.GlobalConstant;

import java.util.Dictionary;
import java.util.HashMap;

public class ApiResponse {
    private static ApiResponse Instance = new ApiResponse();
    public ApiRequest ApiRequest;
    public String EndpointURL;
    public String StatusDescription;
    public int StatusCode;
    public String Content;
//    public String ResponseStatus;

    public static ApiResponse getInstance() {
        if (Instance == null)
            Instance = new ApiResponse();
        return Instance;
    }

    public ApiResponse() {
        ApiRequest = com.somesh.bdd.fw.pojo.api.ApiRequest.getInstance();
        EndpointURL = GlobalConstant.EMPTY;
        StatusDescription = GlobalConstant.EMPTY;
        StatusCode = 0;
        Content = GlobalConstant.EMPTY;
//        ResponseStatus = GlobalConstant.EMPTY;
    }

    public void Clear() {
        EndpointURL = GlobalConstant.EMPTY;
        StatusDescription = GlobalConstant.EMPTY;
        StatusCode = 0;
        Content = GlobalConstant.EMPTY;
//        ResponseStatus = GlobalConstant.EMPTY;
    }
}

