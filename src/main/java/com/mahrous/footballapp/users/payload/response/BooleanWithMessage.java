package com.mahrous.footballapp.users.payload.response;

public class BooleanWithMessage {
    private boolean status;
    private String msg;

    public BooleanWithMessage() {
    }

    public BooleanWithMessage(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
