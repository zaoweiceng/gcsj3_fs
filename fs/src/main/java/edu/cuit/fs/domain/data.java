package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.List;

@Serialization
public class data {
    public Integer code;
    public String description;
    public List<Object> data;

    public data() {
    }

    public data(Integer code, String description, List<Object> data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }
}
