package com.example.rest_api.requist;

public class AddtodoRequist {

    private String name;
    private String owner;
    private boolean status;
    private Long timeofcreare;

    public AddtodoRequist() {

    }

    public AddtodoRequist(String name, String owner, boolean status, Long timeofcreare) {
        this.name = name;
        this.owner = owner;
        this.status = status;
        this.timeofcreare = timeofcreare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getTimeofcreare() {
        return timeofcreare;
    }

    public void setTimeofcreare(Long timeofcreare) {
        this.timeofcreare = timeofcreare;
    }


    public boolean getStatus() {
        return getStatus();
    }
}
