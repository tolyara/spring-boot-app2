package com.springboot.app2.entity.elasticsearch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.app2.enums.elasticsearch.DateFormats;

import java.util.Date;

public class Vehicle {

    private String id;
    private String number;
    private String name;
    @JsonFormat(pattern = DateFormats.yyyy_MM_dd)
    private Date created; // it will be type 'date', this type can be in different cases, like some regular format or timestamp

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
