package dev.napat.handytools.controller.dto;

public class ReturnItemRequest{
    private String location;

    ReturnItemRequest(){}

    public ReturnItemRequest(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
