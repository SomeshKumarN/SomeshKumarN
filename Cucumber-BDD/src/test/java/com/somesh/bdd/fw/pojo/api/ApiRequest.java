package com.somesh.bdd.fw.pojo.api;

import com.somesh.bdd.fw.constant.GlobalConstant;

import java.util.HashMap;

public class ApiRequest {
    private static ApiRequest Instance = new ApiRequest();
    public String EndpointURL;
    public String Method;
    public HashMap<String, String> QueryParams;
    public HashMap<String, String> Headers;
    public String Payload;

    public static ApiRequest getInstance() {
        if (Instance == null)
            Instance = new ApiRequest();
        return Instance;
    }

    public ApiRequest() {
        this.EndpointURL = GlobalConstant.EMPTY;
        Method = GlobalConstant.EMPTY;
        QueryParams = new HashMap<String, String>();
        Headers = new HashMap<String, String>();
        Payload = GlobalConstant.EMPTY;
    }

    public void Clear() {
        EndpointURL = GlobalConstant.EMPTY;
        Method = GlobalConstant.EMPTY;
        QueryParams.clear();
        Headers.clear();
        Payload = GlobalConstant.EMPTY;
    }
}
