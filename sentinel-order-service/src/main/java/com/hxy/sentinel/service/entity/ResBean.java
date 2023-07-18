package com.hxy.sentinel.service.entity;


import java.io.Serializable;

public class ResBean<T> implements Serializable {
    private static final long serialVersionUID = 257617561564691621L;
    public static final String OK = "OK";
    private String code = "OK";
    private String summary = "Success";
    private T result;
    private boolean success = true;

    public void setCode(String code) {
        this.success = "OK".equals(code);

        this.code = code;
    }

    public ResBean() {
    }

    public ResBean(String code) {
        this.code = code;
    }

    public ResBean(String code, String summary) {
        this.code = code;
        this.summary = summary;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        StringBuilder log = new StringBuilder("");
        log.append("code=").append(this.code);
        log.append("|");
        log.append("summary=").append(this.summary);
        return log.toString();
    }
}
