package com.allwyn.dimitris_nikolaidis.assessment.apihelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestHelper {

    private static final Map<String,String> DEFAULT_HEADERS = new HashMap<>(){{
        put("Content-Type", "application/json");
        put("Accept", "text/plain");
    }};


    public Response get(String endpoint, String path) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .basePath(path)
                .contentType("application/json")
                .when()
                .get();
    }


    public Response get(String endpoint, String path, Map<String, String> parameters) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .basePath(path)
                .pathParams(parameters)
                .contentType("application/json")
                .when()
                .get();
    }


    public Response get(String endpoint, String path, String parameter) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .basePath(path+"/"+parameter)
                .contentType("application/json")
                .when()
                .get();
    }

    public Response get(String endpoint) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .contentType("application/json")
                .when()
                .get();
    }

    public Response post(String endpoint, String path, Map<String, String> body,  Map<String,String> headers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return RestAssured
                    .given()
                    .baseUri(endpoint)
                    .basePath(path)
                    .headers(headers != null ? headers : DEFAULT_HEADERS)
                    .body(objectMapper.writeValueAsString(body))
                    .when()
                    .post();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Response post(String endpoint, String path, String body,  Map<String,String> headers) {
            return RestAssured
                    .given()
                    .baseUri(endpoint)
                    .basePath(path)
                    .headers(headers != null ? headers : DEFAULT_HEADERS)
                    .body(body)
                    .when()
                    .post();
    }

    public Response post(String endpoint, String path, Map<String, String> body) {
        return  this.post(endpoint, path, body);
    }

    public Response post(String endpoint, String path, String body) {
        return  this.post(endpoint, path, body, null);
    }

    public Response put(String endpoint, String path, Map<String, String> body) {
        return  this.put(endpoint, path, body, null);
    }

    public Response put(String endpoint, String path, Map<String, String> body,  Map<String,String> headers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return RestAssured
                    .given()
                    .baseUri(endpoint)
                    .basePath(path)
                    .headers(headers != null ? headers : DEFAULT_HEADERS)
                    .body(objectMapper.writeValueAsString(body))
                    .when()
                    .put();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Response put(String endpoint, String path, String id , String body) {
        return this.put(endpoint, path, id, body, null);
    }

    public Response put(String endpoint, String path, String id , String body, Map<String,String> headers) {
            return RestAssured
                    .given()
                    .baseUri(endpoint)
                    .basePath(path + "/" + id)
                    .headers(headers != null ? headers : DEFAULT_HEADERS)
                    .body(body)
                    .when()
                    .put();
    }

    public Response delete(String endpoint, String path, Map<String,String> headers,  Map<String, String> params) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .basePath(path)
                .headers(headers != null ? headers : DEFAULT_HEADERS)
                .params(params)
                .when()
                .delete();
    }

    public Response delete(String endpoint, String path, Map<String,String> headers, String parameter) {
        return RestAssured
                .given()
                .baseUri(endpoint)
                .basePath(path + "/" + parameter)
                .headers(headers != null ? headers : DEFAULT_HEADERS)
                .when()
                .delete();
    }

    public Response delete(String endpoint, String path, String parameter) {
        return this.delete(endpoint, path, null, parameter);
    }


}
