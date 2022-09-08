package com.somesh.bdd.fw.webclient;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class RestClient {
    protected static RequestSpecification CreateRestRequest(String resourceUri,
                                                            HashMap<String, String> headers,
                                                            HashMap<String, String> queryParams, String payload) {

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

    protected static Response ExecuteRestRequest(RequestSpecification request, Method httpMethod) {
        return request.request(httpMethod);
    }

    private static Response TriggerApiCall(String resourceUri, Method httpMethod,
                                           HashMap headers, HashMap queryParams, String payload) {
        var request = CreateRestRequest(resourceUri, headers, queryParams, payload);
        var response = ExecuteRestRequest(request, httpMethod);
        return response;
    }

    public static Response POST(String resourceUri, HashMap headers, String payload) {
        return TriggerApiCall(resourceUri, Method.POST, headers, null, payload);
    }

    public static Response GET(String resourceUri, HashMap headers, HashMap queryParams) {
        return TriggerApiCall(resourceUri, Method.GET, headers, queryParams, null);
    }

    public static Response PUT(String resourceUri, HashMap headers, String payload) {
        return TriggerApiCall(resourceUri, Method.PUT, headers, null, payload);
    }

    public static Response DELETE(String resourceUri, HashMap headers, String payload, HashMap queryParams) {
        return TriggerApiCall(resourceUri, Method.DELETE, headers, queryParams, payload);
    }

    public static Response PATCH(String resourceUri, HashMap headers, String payload) {
        return TriggerApiCall(resourceUri, Method.PATCH, headers, null, payload);
    }

}
