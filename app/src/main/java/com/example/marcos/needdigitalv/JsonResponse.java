package com.example.marcos.needdigitalv;

public class JsonResponse {

    private String response;

    public String getResponse(){
        return  response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "response='" + response + '\'' +
                '}';
    }
}
