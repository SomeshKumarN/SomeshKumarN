package com.somesh.bdd.fw.webclient;

import com.somesh.bdd.fw.constant.ApiMethod;
import com.somesh.bdd.fw.pojo.api.ApiRequest;
import com.somesh.bdd.fw.pojo.api.ApiResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class RestClient {
    public static ApiResponse TriggerAPICall(ApiRequest apiRequest) {
        Response restResponse = null;
        RequestSpecification requestSpecification = RestClient.CreateRestRequest(apiRequest);
        switch (apiRequest.Method) {
            case ApiMethod.GET:
                restResponse = requestSpecification.get();
                break;

            case ApiMethod.PUT:
                restResponse = requestSpecification.put();
                break;

            case ApiMethod.POST:
                restResponse = requestSpecification.post();
                break;

            case ApiMethod.DELETE:
                restResponse = requestSpecification.delete();
                break;

            case ApiMethod.PATCH:
                restResponse = requestSpecification.patch();
                break;
        }
        return RestClient.GetApiResponse(restResponse, apiRequest);
    }

    private static ApiResponse GetApiResponse(Response restResponse, ApiRequest apiRequest) {
        ApiResponse.getInstance().Clear();
        ApiResponse apiResponse = ApiResponse.getInstance();
        apiResponse.ApiRequest = apiRequest;
        apiResponse.EndpointURL = ApiRequest.getInstance().EndpointURL;
        apiResponse.Content = restResponse.body().toString();
        apiResponse.StatusDescription = restResponse.getStatusLine().toString();
        apiResponse.StatusCode = restResponse.getStatusCode();
//        apiResponse.ResponseStatus = restResponse.get.ToString();
        return apiResponse;
    }

    private static RequestSpecification CreateRestRequest(ApiRequest apiRequest) {
        return CreateRestRequest(apiRequest.EndpointURL,
                apiRequest.Headers,
                apiRequest.QueryParams,
                apiRequest.Payload);
    }

    private static RequestSpecification CreateRestRequest(String resourceUri,
                                                          HashMap<String, String> headers,
                                                          HashMap<String, String> queryParams,
                                                          String payload) {

        RequestSpecification request = RestAssured.given().baseUri(resourceUri);

        if (headers != null) {
            request.headers(headers);
        }
        if (queryParams != null) {
            request.queryParams(queryParams);
        }
        if (payload != null) {
            request.body(payload);
        }

        return request;
    }
}
