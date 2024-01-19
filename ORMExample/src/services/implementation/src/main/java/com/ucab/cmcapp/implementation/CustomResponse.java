package com.ucab.cmcapp.implementation;

public class CustomResponse<T> {

    public T response  = null;
    public String description;

    public CustomResponse(T response, String description){
        this.response = response;
        this.description = description;
    }

    public CustomResponse(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
