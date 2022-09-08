package com.somesh.bdd.fw.webclient;

import com.somesh.bdd.fw.constant.ApiMethod;
import com.somesh.bdd.fw.pojo.api.ApiRequest;
import com.somesh.bdd.fw.pojo.api.ApiResponse;
import io.restassured.response.Response;

public class RestHelper {
    public static ApiResponse TriggerAPICall(ApiRequest apiRequest)
    {
        Response restResponse = null;
        switch (apiRequest.Method)
        {
            case ApiMethod.GET:
                restResponse = RestClient.GET(apiRequest.EndpointURL, apiRequest.Headers, apiRequest.QueryParams);
                break;

            case ApiMethod.PUT:
                restResponse = RestClient.PUT(apiRequest.EndpointURL, apiRequest.Headers, apiRequest.Payload);
                break;

            case ApiMethod.POST:
                restResponse = RestClient.POST(apiRequest.EndpointURL, apiRequest.Headers, apiRequest.Payload);
                break;

            case ApiMethod.DELETE:
                restResponse = RestClient.DELETE(apiRequest.EndpointURL, apiRequest.Headers, apiRequest.Payload, apiRequest.QueryParams);
                break;

            case ApiMethod.PATCH:
                restResponse = RestClient.PATCH(apiRequest.EndpointURL, apiRequest.Headers, apiRequest.Payload);
                break;
        }
        return RestHelper.GetApiResponse(restResponse, apiRequest);
    }

    public static ApiResponse GetApiResponse(Response restResponse, ApiRequest apiRequest)
    {
        ApiResponse.getInstance().Clear();
        ApiResponse apiResponse = ApiResponse.getInstance();
        apiResponse.ApiRequest = apiRequest;
        apiResponse.EndpointURL = ApiRequest.getInstance().EndpointURL;
        apiResponse.Content = restResponse.getBody().toString();
        apiResponse.StatusDescription = restResponse.getStatusLine().toString();
        apiResponse.StatusCode = restResponse.getStatusCode();
//        apiResponse.ResponseStatus = restResponse.get.ToString();
        return apiResponse;
    }
}
