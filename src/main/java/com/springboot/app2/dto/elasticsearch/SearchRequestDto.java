package com.springboot.app2.dto.elasticsearch;

import java.util.List;

public class SearchRequestDto {

    private List<String> fields;
    private String searchItem;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

}
